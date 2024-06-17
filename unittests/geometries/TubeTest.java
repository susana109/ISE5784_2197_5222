package geometries;

import org.junit.jupiter.api.Test;
import primitives.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Testing Tubes
 */
class TubeTest {
    /**
     * Delta value for accuracy when comparing the numbers of type 'double' in assertEquals
     */
    private final double DELTA = 0.000001;

    /**
     * Test method for {@link geometries.Tube#getNormal(primitives.Point)}.
     */
    @Test
    void testGetNormal() {
        // ============ Equivalence Partitions Tests ==============

        Ray ray = new Ray(new Point(0, 0, 0), new Vector(0, 0, 1));
        Tube tube = new Tube(ray, 40);
        Point point = new Point(1, 0, 2);
        Vector tNormal = tube.getNormal(point);

        // Ensure the normal is as expected
        assertEquals(new Vector(1, 0, 0), tNormal, "Error: Tube getNormal not returning correct value");

        // Ensure |result| = 1
        assertEquals(1, tNormal.length(), DELTA, "Error: Tube's normal is not a unit vector");

        // Ensure the result is orthogonal to the tube's axis
        assertEquals(0, tNormal.dotProduct(ray.getDirection()), DELTA, "Error: Tube's normal is not orthogonal to the tube's axis");

        // =============== Boundary Values Tests ==================
        // The point on the tube creates a 90-degree angle to the ray
        Point p = new Point(1, 0, 0);

        // Corrected the normal vector expected
        Vector expectedNormal = new Vector(1, 0, 0);
        /**assertEquals(expectedNormal,
         tube.getNormal(p),
         "Error: Tube's normal is not correct for the given point");
         */
    }
}
