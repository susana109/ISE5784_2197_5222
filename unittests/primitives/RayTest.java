package primitives;

import java.util.*;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RayTest {

    @Test
    void getPoint() {
        Point p1 = new Point(1, 0, 0);
        Vector v1 = new Vector(1, 0, 0);
        Ray r1 = new Ray(p1, v1);
        // ============ Equivalence Partitions Tests ==============
        //TC01:Positive distance
        assertEquals(new Point(4, 0, 0), r1.getPoint(3), "Wrong pont with a positive distance");
        //TC02:Negative distance
        assertEquals(new Point(-2, 0, 0), r1.getPoint(-3), "Wrong pont with a negative distance");
        // =============== Boundary Values Tests ==================
        //TC03:Distance zero(return head of ray)
        assertEquals(r1.getHead(), r1.getPoint(0), "Wrong pont with a distance of zero");
    }

    @Test
    void findClosestPointTest() { //a tester!!!!!!
        Point p1 = new Point(0, 0, 0);
        Point p2 = new Point(3, 3, 3);
        Point p3 = new Point(4, 4, 4);
        Ray myRay=new Ray(new Point(2,2,2), new Vector(1,1,1));
        Ray myRay2=new Ray(new Point(-1,-1,-1), new Vector(1,1,1));
        Ray myRay3=new Ray(new Point(5,5,5), new Vector(1,1,1));
        List<Point> points = new ArrayList<Point>(Arrays.asList(p1, p2, p3));
        List<Point> points2 = new ArrayList<>();

        // ============ Equivalence Partitions Tests ==============
        //TC01:the closest point to the ray’s head is found somewhere in the middle of the list
        assertEquals(p2, myRay.findClosestPoint(points), "Wrong closest point");

        // =============== Boundary Values Tests ==================
        // TC02: the list of points is empty
        assertNull(myRay.findClosestPoint(points2), "The list of points is empty");

        // TC03:the closest point is the first point in the list
        assertEquals(p1, myRay2.findClosestPoint(points), "Wrong closest point");

        // TC04:the closest point is the last point in the list
        assertEquals(p1, myRay3.findClosestPoint(points), "Wrong closest point");
    }
}