package geometries;

import primitives.Point;
import primitives.Vector;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Testing Triangles
 */
class TriangleTest {
    /**
     * Delta value for accuracy when comparing the numbers of type 'double' in assertEquals
     */
    private final double DELTA = 0.000001;

    /**
     * Test method for {@link geometries.Triangle#getNormal(primitives.Point)}.
     */
    @org.junit.jupiter.api.Test
    void testGetNormal() {
        // ============ Equivalence Partitions Tests ==============
        Point p1 = new Point(0, 0, 0);
        Point p2 = new Point(1, 0, 0);
        Point p3 = new Point(0, 1, 0);
        Triangle triangle = new Triangle(p1, p2, p3);
        Vector result = triangle.getNormal(p1);
        //TC01: ensure |result| = 1
        assertEquals(1, result.length(), DELTA, "Triangle's normal is not a unit vector");
        // TC02:ensure the result is orthogonal to the vector director of the plane
        Vector vd = p1.subtract(p2);
        assertEquals(0, vd.dotProduct(result), DELTA, "Triangle's normal is not orthogonal to the triangle");
    }
}
