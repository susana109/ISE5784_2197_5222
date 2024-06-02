package geometries;

import org.junit.jupiter.api.Test;
import primitives.Point;
import primitives.Vector;

import static org.junit.jupiter.api.Assertions.*;

class PlaneTest {
    private final double DELTA = 0.000001;

    /**
     * Test method for {@link geometries.Plane#getNormal(primitives.Point)}.
     */
    @Test
    void testGetNormal() {
        // Test code for getNormal method should be implemented here.
    }

    /**
     * Test method for {@link geometries.Plane#getNormal(primitives.Point)}.
     */
    @Test
    void testTestGetNormal() {
        // ============ Equivalence Partitions Tests ==============
        Point p1 = new Point(0, 0, 1);
        Point p2 = new Point(1, 0, 0);
        Point p3 = new Point(0, 1, 0);

        Plane pl = new Plane(p1, p2, p3);
        Vector result = pl.getNormal(p1);

        // Ensure |result| = 1
        assertEquals(1, result.length(), DELTA, "Plane's normal is not a unit vector");

        // Ensure the result is orthogonal to the vector director of the plane
        Vector vd = p1.subtract(p2);
        assertEquals(0, vd.dotProduct(result), DELTA,
                "Plane's normal is not orthogonal to the vector director of the plane");

        // =============== Boundary Values Tests ==================

        Point p4 = new Point(0, 0, 1);
        assertThrows(IllegalArgumentException.class, () -> new Plane(p1, p4, p2),
                "ERROR: Plane's constructor must have 3 different points");
        Vector vd1 = p1.subtract(p2);
        Vector vd2 = p1.subtract(p3);
        assertNotEquals(0, vd1.dotProduct(vd2), DELTA, "ERROR: The points are all on the same line");
    }
}
