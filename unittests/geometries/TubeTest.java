package geometries;

import org.junit.jupiter.api.Test;
import primitives.Point;
import primitives.Ray;
import primitives.Vector;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * /**
 * Testing Tubes
 */
class TubeTest {
    /**
     * Delta value for accuracy when comparing the numbers of type 'double' in
     * assertEquals
     */
    private final double DELTA = 0.000001;

    /**
     * Test method for {@link geometries.Tube#getNormal(primitives.Point)}.
     */
    @Test
    void testGetNormal() {//ok

        // ============ Equivalence Partitions Tests ==============

        Ray ray = new Ray(new Point(0, 0, 0), new Vector(0, 0, 1));
        Tube tube = new Tube(40, ray);
        Point point = new Point(1, 0, 2);
        Vector tNormal = tube.getNormal(point);


        assertEquals(tNormal, new Vector(1, 0, 0), "Error: Tube getNormal not returning correct value");


        // ============ Equivalence Partitions Tests ==============
        // ensure |result| = 1
        assertEquals(1, tNormal.length(), DELTA, "Error:Tube's normal is not a unit vector");

        // ensure the result is orthogonal to the tube's axis
        assertEquals(0, tNormal.dotProduct(new Vector(0, 0, 1)), DELTA,
                "Error:Tube's normal is not orthogonal to the tube's axis");

        // =============== Boundary Values Tests ==================
        // the point on the tube creates a 90-degree angle to the ray

        Point p = new Point(1, 0, 0);

        assertThrows(IllegalArgumentException.class, () -> tube.getNormal(p).dotProduct(new Vector(0, 0, 1)),
                "Error:Tube's normal is not orthogonal to the tube's axis");
    }
}
