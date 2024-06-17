package geometries;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import primitives.*;
import java.util.ArrayList;
import java.util.Arrays;

class GeometriesTest {



    @Test
    void testFindIntersections() {
        Geometries geometries = new Geometries();

        //---------------BVA------ - no geometries in collection
        assertNull( geometries.findIntersections(new Ray(Point.ZERO ,
                new Vector(1,0,0))),
                "ERROR - no intersections when no geometries in collection");


        //---------------BVA------ ALL GEOMETRIES HAS INTERSECTIONS
        geometries.add(new Plane(new Point(0,0,4), new Point(0,-2,0), new Point(2,0,0)),
                new Triangle(new Point(0,3.13,0) ,new Point(0,0,1), new Point(-3,0,0)));
        assertNull(geometries.findIntersections(new Ray(new Point(0,6,0),
                        new Vector(-10,-6,0).normalize())),
                "ERROR - no intersections at all between the geometries " );

        //---------------BVA------ ONLY ONE GEOMETRY HAS INTERSECTION
        /*assertEquals(new ArrayList<Point>(
                        Arrays.asList(new Point(0.006246096189881811, -0.4896939412866957, 3.0081199250468456))),
                geometries.findIntersections(new Ray(new Point(10,0,0), new Vector(-10,-0.49,3.01).normalize()))
        ,"ERROR - only one geometry has intersection  " );*/

        ArrayList<Point> arrayPoint3D =  new ArrayList<Point>(
                Arrays.asList(new Point(0.006246096189881811,-0.4896939412866957,3.0081199250468456),
                        new Point(-0.4918032786885256,-0.5140983606557377,3.1580327868852462)));


        geometries.add(new Triangle(new Point(-6,0,0) ,new Point(0,-4,0), new Point(0,0,4)));

        //---------------EP------ - intersections, not all geometries
        assertEquals(new ArrayList<Point>(
                        Arrays.asList(new Point(0.006246096189881811,-0.4896939412866957,3.0081199250468456),
                                new Point(-0.4918032786885256,-0.5140983606557377,3.1580327868852462))),
                geometries.findIntersections(new Ray(new Point(10,0,0),new Vector(-10,-0.49,3.01).normalize())),
                "ERROR - some geometries but not all of them has intersections   " );


        //---------------BVA------ ALL GEOMETRIES HAS INTERSECTIONS
        Geometries geometries2 = new Geometries();
        geometries2.add(new Plane(new Point(0,1,0), new Point(1,0,0), new Point(0,0,1)),
                new Triangle(new Point(3,0,0) ,new Point(0,0,3), new Point(0,3,0)),
                new Triangle(new Point(0,-5,0) ,new Point(0,0,5), new Point(-5,0,0)));
        assertEquals(new ArrayList<Point>(
                        Arrays.asList(new Point(0.2892421441774484, -0.3424768946395571, 1.0532347504621073),
                                new Point(1.4759334565619229, 0.7554898336414051, 0.7685767097966727),
                                new Point(-1.509064748201438, -2.0063309352517984, 1.4846043165467624))),
                geometries2.findIntersections(new Ray(new Point(4.68,3.72,0), new Vector(-3.21,-2.97,0.77).normalize())),
                "ERROR - all the geometries has intersections   " );

    }
}