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
        Point point = new Point(0, 0, 2);
        Vector tNormal = tube.getNormal(point);


        assertEquals(tNormal, new Vector(0, 0, 1), "Error: Tube getNormal not returning correct value");



        /** ============ Equivalence Partitions Tests ==============
        // ensure |result| = 1
        assertEquals(1, tNormal.length(), DELTA, "Error:Tube's normal is not a unit vector");

        // ensure the result is orthogonal to the tube's axis
        assertEquals(0, tNormal.dotProduct(), DELTA, "Error:Tube's normal is not orthogonal to the tube's axis");*/

        // =============== Boundary Values Tests ==================
        // a point on the tube creates a 90-degree angle to the ray
        // a point on the tube at 90 degrees from the point p1

        Point p = new Point(2, 0, 1);
        // vector from p1 to p parallel to the normal
        Vector v = p.subtract(point);

        assertEquals(v.crossProduct(tNormal), Double3.ZERO, "Error:Tube's normal is not orthogonal to the tube's axis");
    }
}
