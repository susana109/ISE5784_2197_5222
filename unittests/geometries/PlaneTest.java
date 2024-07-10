package geometries;

import org.junit.jupiter.api.Test;
import primitives.Point;
import primitives.Ray;
import primitives.Vector;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Testing Planes
 */
class PlaneTest {
    private final double DELTA = 0.000001;

    /**
     * Test method for {@link geometries.Plane#getNormal(primitives.Point)}.
     */
    @Test
    void testGetNormal() {//ok
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
    }

    /**
     * Test method for {@link geometries.Plane#findIntersections(primitives.Ray)}.
     */
    @Test
    void testFindIntersections() {//ok
        Plane p = new Plane(new Point(1, 0, 0), new Point(0, 1, 0), new Point(0, 0, 1));

        // ============ Equivalence Partitions Tests ==============
        // TC01: Ray intersects the plane (1 point)
        Ray r1 = new Ray(new Point(0, -1, 0), new Vector(0, 1, 1).normalize());
        List<Point> intersections = p.findIntersections(r1);
        assertNotNull(intersections, "Ray intersects the plane");
        assertEquals(1, intersections.size(), "Wrong number of intersection points");

        // TC02: Ray does not intersect the plane (0 points)
        Ray r2 = new Ray(new Point(2, 0, 0), new Vector(4, -2, 0).normalize());
        assertNull(p.findIntersections(r2), "Ray does not intersect the plane");

        // =============== Boundary Values Tests ==================
        // TC03: Ray is parallel and outside the plane (0 points)
        Ray r3 = new Ray(new Point(2.32, -1.33, 0), new Vector(-3.62, -3.71, 7.33).normalize());
        assertNull(p.findIntersections(r3), "Ray is parallel and outside the plane");

        // TC04: Ray is orthogonal to the plane and starts before the plane (1 point)
        Ray r4 = new Ray(new Point(0, 0, -1), new Vector(0, 0, 1).normalize());
        intersections = p.findIntersections(r4);
        assertNotNull(intersections, "Ray is orthogonal to the plane and starts before the plane");
        assertEquals(1, intersections.size(), "Wrong number of intersection points");

        // TC05: Ray is orthogonal to the plane and starts in the plane (0 points)
        Ray r5 = new Ray(new Point(0, 1, 0), new Vector(0, 0, 1).normalize());
        assertNull(p.findIntersections(r5), "Ray is orthogonal to the plane and starts in the plane");

        // TC06: Ray is orthogonal to the plane and starts after the plane (0 points)
        Ray r6 = new Ray(new Point(0, 0, 2), new Vector(0, 0, 1).normalize());
        assertNull(p.findIntersections(r6), "Ray is orthogonal to the plane and starts after the plane");

        // TC07: Ray starts in the plane and goes outside (0 points)
        Ray r7 = new Ray(new Point(1, 0, 0), new Vector(1, 1, 1).normalize());
        assertNull(p.findIntersections(r7), "Ray starts in the plane and goes outside");

        // TC08: Ray starts outside the plane and goes inside (1 point)
        Ray r8 = new Ray(new Point(-1, -1, -1), new Vector(2, 3, 1).normalize());
        intersections = p.findIntersections(r8);
        assertNotNull(intersections, "Ray starts outside the plane and goes inside");
        assertEquals(1, intersections.size(), "Wrong number of intersection points");
    }
}
