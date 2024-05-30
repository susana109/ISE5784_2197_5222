package geometries;

import org.junit.jupiter.api.Test;
import primitives.*;
import static org.junit.jupiter.api.Assertions.*;

class TubeTest {
    private final double DELTA = 0.000001;
    @Test
    void testGetNormal() {
        Point p1= new Point(0, 0, 1);
        Vector v1         = new Vector(1, 2, 3);
        Ray r1         = new Ray(p1, v1);
        Tube tube =new Tube(r1,2);
        Vector result = tube.getNormal(p1);
        // ============ Equivalence Partitions Tests ==============
        // ensure |result| = 1
        assertEquals(1, result.length(), DELTA, "Plane's normal is not a unit vector");
        // ensure the result is orthogonal to the tube
        assertEquals(0,v1.dotProduct(result),DELTA,
                "Tube's normal is not orthogonal to the tube's axis" );
        // =============== Boundary Values Tests ==================
        // a point on the tube creates a 90deg angle to the ray
        //a point on the tube at 90 deg of the point p1
        Point p=new Point(2,0,1);
        //vector from p1 to p parallel to the normal
        Vector v=p.subtract(p1);
        assertTrue(v1.crossProduct(result).equals(Double3.ZERO),
                "Tube's normal is not orthogonal to the tube's axis" );
    }
}