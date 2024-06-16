package geometries;

import java.util.List;
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
     * Test method for {@link geometries.Sphere#getNormal(primitives.Point)}.
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
        assertEquals(0, vd.dotProduct(result), DELTA, "Sphere's normal is not orthogonal to the sphere");
    }

    private final Point p001 = new Point(0, 0, 1);
    private final Point p100 = new Point(1, 0, 0);

    /**
     * Test method for {@link geometries.Sphere#findIntersections(primitives.Ray)}.
     */
    @Test
    public void testFindIntersections() {
        Sphere sphere = new Sphere(p100, 1d);
        final Point gp1 = new Point(0.0651530771650466, 0.355051025721682, 0);
        final Point gp2 = new Point(1.53484692283495, 0.844948974278318, 0);
        final var exp = List.of(gp1, gp2);
        final Vector v310 = new Vector(3, 1, 0);
        final Vector v110 = new Vector(1, 1, 0);
        final Point p01 = new Point(-1, 0, 0);

        // ============ Equivalence Partitions Tests ==============
        // TC01: Ray's line is outside the sphere (0 points)
        assertNull(sphere.findIntersections(new Ray(p01, v110)), "Ray's line out of sphere");

        // TC02: Ray starts before and crosses the sphere (2 points)
        final var result1 = sphere.findIntersections(new Ray(p01, v310));
        assertEquals(2, result1.size(), "Wrong number of points");
        assertTrue(result1.contains(new Point(0.0651530771650466, 0.355051025721682, 0)), "Intersection point 1 is incorrect");
        assertTrue(result1.contains(new Point(1.53484692283495, 0.844948974278318, 0)), "Intersection point 2 is incorrect");

        // TC03: Ray starts inside the sphere (1 point)
        assertEquals(List.of(gp2), sphere.findIntersections(new Ray(new Point(0.5, 0.5, 0), new Vector(3, 1, 0).normalize())), "Ray from inside sphere");

        // TC04: Ray starts after the sphere (0 points)
        assertNull(sphere.findIntersections(new Ray(new Point(3, 3, 3), new Vector(1, 1, 1))), "Ray starts after the sphere");

        // =============== Boundary Values Tests ==================
        // **** Group: Ray's line crosses the sphere (but not the center)
        // TC11: Ray starts at sphere and goes inside (1 points)
        assertEquals(List.of(new Point(1, 1, 0)), sphere.findIntersections(new Ray(new Point(1, 0, 0), new Vector(0, 1, 0))), "Ray starts at sphere and goes inside");

        // TC12: Ray starts at sphere and goes outside (0 points)
        assertNull(sphere.findIntersections(new Ray(new Point(1, 0, 0), new Vector(0, -1, 0))), "Ray starts at sphere and goes outside");

        // **** Group: Ray's line goes through the center
        // TC13: Ray starts before the sphere (2 points)
        assertEquals(List.of(new Point(0, 0, 1), new Point(2, 0, 1)), sphere.findIntersections(new Ray(new Point(-1, 0, 1), new Vector(1, 0, 0))), "Ray starts before the sphere");

        // TC14: Ray starts at sphere and goes inside (1 points)
        assertEquals(List.of(new Point(2, 0, 1)), sphere.findIntersections(new Ray(new Point(1, 0, 1), new Vector(1, 0, 0))), "Ray starts at sphere and goes inside");

        // TC15: Ray starts inside (1 points)
        assertEquals(List.of(new Point(2, 0, 1)), sphere.findIntersections(new Ray(new Point(1.5, 0, 1), new Vector(1, 0, 0))), "Ray starts inside the sphere");

        // TC16: Ray starts at the center (1 points)
        assertEquals(List.of(new Point(2, 0, 1)), sphere.findIntersections(new Ray(new Point(1, 0, 1), new Vector(1, 0, 0))), "Ray starts at the center");

        // TC17: Ray starts at sphere and goes outside (0 points)
        assertNull(sphere.findIntersections(new Ray(new Point(1, 0, 1), new Vector(-1, 0, 0))), "Ray starts at sphere and goes outside");

        // TC18: Ray starts after sphere (0 points)
        assertNull(sphere.findIntersections(new Ray(new Point(3, 0, 1), new Vector(1, 0, 0))), "Ray starts after the sphere");

        // **** Group: Ray's line is tangent to the sphere (all tests 0 points)
        // TC19: Ray starts before the tangent point
        assertNull(sphere.findIntersections(new Ray(new Point(0, -1, 0), new Vector(1, 0, 0))), "Ray starts before the tangent point");

        // TC20: Ray starts at the tangent point
        assertNull(sphere.findIntersections(new Ray(new Point(1, -1, 0), new Vector(0, 1, 0))), "Ray starts at the tangent point");

        // TC21: Ray starts after the tangent point
        assertNull(sphere.findIntersections(new Ray(new Point(2, -1, 0), new Vector(1, 0, 0))), "Ray starts after the tangent point");

        // **** Group: Special cases
        // TC22: Ray's line is outside, ray is orthogonal to ray start to sphere's center line
        assertNull(sphere.findIntersections(new Ray(new Point(1, -1, 0), new Vector(0, 0, 1))), "Ray is orthogonal to ray start to sphere's center line");
    }
}
