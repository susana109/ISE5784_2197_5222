package geometries;

import org.junit.jupiter.api.Test;
import primitives.*;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Testing Spheres
 */
class SphereTest {
    /**
     * Delta value for accuracy when comparing the numbers of type 'double' in assertEquals
     */
    private final double DELTA = 0.000001;

    /**
     * Test method
     */
    @Test
    void testGetNormal() {
        // ============ Equivalence Partitions Tests ==============
        // p1 is the center of the sphere
        Point p1 = new Point(0, 0, 1);
        // p2 is a point on the sphere
        Point p2 = new Point(2, 0, 1);
        Sphere sphere = new Sphere(p1, 2);
        Vector result = sphere.getNormal(p2);
        // ensure |result| = 1
        assertEquals(1, result.length(), DELTA, "Sphere's normal is not a unit vector");
        // ensure the result is orthogonal to the radius vector
        Vector vd = p2.subtract(p1);
        assertThrows(IllegalArgumentException.class, () ->  vd.crossProduct(result),
                "Sphere's normal is not orthogonal to the sphere");

    }
}