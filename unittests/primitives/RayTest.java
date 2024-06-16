package primitives;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RayTest {

    @Test
    void getPoint() {
        Point p1= new Point(1,0,0);
        Vector v1 = new Vector(1,0,0);
        Ray r1 = new Ray(p1,v1);
        // ============ Equivalence Partitions Tests ==============
        //TC01:Positive distance
        assertEquals(new Point(4,0,0),r1.getPoint(3),"Wrong pont with a positive distance");
        //TC02:Negative distance
        assertEquals(new Point(-2,0,0),r1.getPoint(-3),"Wrong pont with a negative distance");
        // =============== Boundary Values Tests ==================
        //TC03:Distance zero(return head of ray)
        assertEquals(r1.getHead(),r1.getPoint(0),"Wrong pont with a distance of zero");


    }
}