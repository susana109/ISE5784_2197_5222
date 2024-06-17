package geometries;

import org.junit.jupiter.api.Test;
import primitives.*;

import java.util.List;

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
     * Test method for {@link Triangle#getNormal(Point)}.
     */
    @Test
    void testGetNormal() {//ok
        // ============ Equivalence Partitions Tests ==============
        Point p1 = new Point(0, 0, 0);
        Point p2 = new Point(1, 0, 0);
        Point p3 = new Point(0, 1, 0);
        Triangle triangle = new Triangle(p1, p2, p3);
        Vector result = triangle.getNormal(p1);
        // ensure |result| = 1
        assertEquals(1, result.length(), DELTA, "Triangle's normal is not a unit vector");
        // ensure the result is orthogonal to the vector director of the plane
        Vector vd = p1.subtract(p2);
        assertEquals(0, vd.dotProduct(result), DELTA, "Triangle's normal is not orthogonal to the triangle");
    }

    /**
     * findIntersections
     */
    @Test
    public void findIntersections() {//ok
        //Triangle t = new Triangle(new Point3D(2,0,0),new Point3D(0,0,2),new Point3D(0,2,0));
        Triangle t = new Triangle(new Point(0,2,0),new Point(0,0,2),new Point(2,0,0));
        //EP - Ray intersects triangle in the middle
        Ray r1 = new Ray(new Point(3.03,3.26,0), new Vector(-2.71,-2.59,1.01).normalize());


        List<Point> intersection = t.findIntersections(r1);

        assertEquals( 1, intersection.size(),"Error, no intersection with ray inside triangle");

        //EP - Ray no intersect triangle - outside edge
        Ray r2 = new Ray(new Point(-1,-2,1), new Vector(3,10,3).normalize());

        List<Point> no_intersections1 = t.findIntersections(r2);

        assertEquals(null, no_intersections1, "Error, intersection with ray outside triangle with edge");


        //EP - Ray no intersect triangle - outside vertex
        Ray r3 = new Ray(new Point(2.01,2.82,0), new Vector(0,0,2.15).normalize());

        List<Point> no_intersections2 = t.findIntersections(r3);

        assertEquals(null, no_intersections2, "Error, intersection with ray outside triangle with vertex");



        /***BVA***/

        //BVA - no intersection with ray on edge triangle
        Ray r4 = new Ray(new Point(2.57, 2.48, 0), new Vector(1.14,0,0.86).normalize());

        List<Point> noIntersections3 = t.findIntersections(r4);



        assertEquals(null, noIntersections3, "Error, intersection with ray on edge triangle");

        //VBA  - no intersection with ray on vertex triangle
        Ray r5 = new Ray(new Point(3.53,1.25,0), new Vector(2,0,0).normalize());

        List<Point> no_intersections4 = t.findIntersections(r5);

        assertEquals(null, no_intersections4, "Error, intersection with ray on vertex triangle");

        //VBA - no intersect, ray outside triangle, continue of edge..
        Ray r6 = new Ray(new Point(3.46,1.65,0), new Vector(0, -0.5, 2.5).normalize());


        List<Point> no_intersections5 = t.findIntersections(r6);

        assertEquals(null, no_intersections5, "Error, intersection with ray outside triangle continues edge");

    }
}