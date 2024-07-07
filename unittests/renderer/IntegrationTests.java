package renderer;
import geometries.Plane;
import geometries.Sphere;
import geometries.Triangle;
import org.junit.Test;
import primitives.Point;
import primitives.Ray;
import primitives.Vector;
import java.util.List;
import static org.junit.Assert.assertEquals;

public class IntegrationTests {
   @Test
   public void test() {

//verifier si on laisse un seul de chaque forme

/**
 * IntegrationTest
 */


       Camera cam1 = new Camera(Point.ZERO, new Vector(new Point(0, 0, 1)), new Vector(0, -1, 0));
       Camera cam2 = new Camera(new Point(0, 0, -0.5), new Vector(new Point(0, 0, 1)), new Vector(0, -1, 0));

       double screenDistance = 1;
       double screenWidth = 3;
       double screenHeight = 3;
       int Nx = 3;
       int Ny = 3;
   }
         /**
          * IntegrationSphereTest
          */
         @Test
         public void IntegrationSphereTest()
         {
            Sphere sp = new Sphere(new Point(0,0,3), 1);
            int count = 0;

            for(int i = 0;i < Nx;i++)
            {
               for(int j = 0;j < Ny;j++)
               {
                  Ray r = cam1.constructRayThroughPixel(Nx,Ny,j,i,screenDistance,screenWidth,screenHeight);
                  List<Point> listPoints = sp.findIntersections(r);
                  count += (listPoints != null ? listPoints.size() : 0);
               }
            }

            assertEquals("ERROR - INTEGRATION SPHERE FAILED ON 2 INTERSECTIONS", 2, count);

         }

         /**
          * IntegrationSphere2Test
          */
         @Test
         public void IntegrationSphere2Test()
         {
            Sphere sp = new Sphere(new Point(0,0,2.5), 2.5);
            int count = 0;

            for(int i = 0;i < Nx;i++)
            {
               for(int j = 0;j < Ny;j++)
               {
                  Ray r = cam2.constructRayThroughPixel(Nx,Ny,j,i,screenDistance,screenWidth,screenHeight);
                  List<Point> listPoints = sp.findIntersections(r);
                  count += (listPoints != null ? listPoints.size() : 0);
               }
            }

            assertEquals("ERROR - INTEGRATION SPHERE FAILED ON 18 INTERSECTIONS", 18, count);

         }

         /**
          * IntegrationSphere3Test
          */
         @Test
         public void IntegrationSphere3Test()
         {
            Sphere sp = new Sphere(new Point(0,0,2), 2);
            int count = 0;

            for(int i = 0;i < Nx;i++)
            {
               for(int j = 0;j < Ny;j++)
               {
                  Ray r = cam2.constructRayThroughPixel(Nx,Ny,j,i,screenDistance,screenWidth,screenHeight);
                  List<Point> listPoints = sp.findIntersections(r);
                  count += (listPoints != null ? listPoints.size() : 0);
               }
            }

            assertEquals("ERROR - INTEGRATION SPHERE FAILED ON 10 INTERSECTIONS", 10, count);

         }

         /**
          * IntegrationSphere4Test
          */
         @Test
         public void IntegrationSphere4Test()
         {
            Sphere sp = new Sphere(new Point(0,0,2), 4);
            int count = 0;

            for(int i = 0;i < Nx;i++)
            {
               for(int j = 0;j < Ny;j++)
               {
                  Ray r = cam2.constructRayThroughPixel(Nx,Ny,j,i,screenDistance,screenWidth,screenHeight);
                  List<Point> listPoints = sp.findIntersections(r);
                  count += (listPoints != null ? listPoints.size() : 0);
               }
            }

            assertEquals("ERROR - INTEGRATION SPHERE FAILED ON 9 INTERSECTIONS", 9, count);

         }

         /**
          * IntegrationSphere5Test
          */
         @Test
         public void IntegrationSphere5Test()
         {
            Sphere sp = new Sphere(new Point(0,0,-1), 0.5d);
            int count = 0;

            for(int i = 0;i < Nx;i++)
            {
               for(int j = 0;j < Ny;j++)
               {
                  Ray r = cam2.constructRayThroughPixel(Nx,Ny,j,i,screenDistance,screenWidth,screenHeight);
                  List<Point> listPoints = sp.findIntersections(r);
                  count += (listPoints != null ? listPoints.size() : 0);
               }
            }

            assertEquals("ERROR - INTEGRATION SPHERE FAILED ON 0 INTERSECTIONS", 0, count);

         }

         /**
          * IntegrationTriangleTest
          */
         @Test
         public void IntegrationTriangleTest()
         {
            Triangle tr = new Triangle(new Point(1,1,2), new Point(0,-1,2), new Point(-1,1,2));
            int count = 0;

            for(int i = 0;i < Nx;i++)
            {
               for(int j = 0;j < Ny;j++)
               {
                  Ray r = cam1.constructRayThroughPixel(Nx,Ny,j,i,screenDistance,screenWidth,screenHeight);
                  List<Point> listPoints = tr.findIntersections(r);
                  count += (listPoints != null ? listPoints.size() : 0);
               }
            }

            assertEquals("ERROR - INTEGRATION TRIANGLE FAILED ON 1 INTERSECTIONS", 1, count);

         }

         /**
          * IntegrationTriangle2Test
          */
         @Test
         public void IntegrationTriangle2Test()
         {
            Triangle tr = new Triangle(new Point(1,1,2), new Point(0,-20,2), new Point(-1,1,2));
            int count = 0;

            for(int i = 0;i < Nx;i++)
            {
               for(int j = 0;j < Ny;j++)
               {
                  Ray r = cam1.constructRayThroughPixel(Nx,Ny,j,i,screenDistance,screenWidth,screenHeight);
                  List<Point> listPoints = tr.findIntersections(r);
                  count += (listPoints != null ? listPoints.size() : 0);
               }
            }

            assertEquals("ERROR - INTEGRATION TRIANGLE FAILED ON 2 INTERSECTIONS", 2, count);

         }

         /**
          * IntegrationPlaneTest
          */
         @Test
         public void IntegrationPlaneTest()
         {
            Plane pl = new Plane(new Point(0,3,3), new Point(0,-3,3), new Point(1,5,3));
            int count = 0;

            for(int i = 0;i < Nx;i++)
            {
               for(int j = 0;j < Ny;j++)
               {
                  Ray r = cam1.constructRayThroughPixel(Nx,Ny,j,i,screenDistance,screenWidth,screenHeight);
                  List<Point> listPoints = pl.findIntersections(r);
                  count += (listPoints != null ? listPoints.size() : 0);
               }
            }

            assertEquals("ERROR - INTEGRATION PLANE FAILED ON 9 INTERSECTIONS", 9, count);

         }

         /**
          * IntegrationPlane2Test
          */
         @Test
         public void IntegrationPlane2Test()
         {
            //Plane pl = new Plane(new Point3D(1,8,0), new Point3D(0,0,3), new Point3D(5,-5,5));
            Plane pl = new Plane(new Point(-1,-20,-10), new Point(0,15,10), new Point(1,-20,-10));

            int count = 0;

            for(int i = 0;i < Nx;i++)
            {
               for(int j = 0;j < Ny;j++)
               {
                  Ray r = cam1.constructRayThroughPixel(Nx,Ny,j,i,screenDistance,screenWidth,screenHeight);
                  List<Point> listPoints = pl.findIntersections(r);
                  count += (listPoints != null ? listPoints.size() : 0);
               }
            }

            assertEquals("ERROR - INTEGRATION PLANE FAILED ON 9 INTERSECTIONS", 9, count);

         }

         /**
          * IntegrationPlane3Test
          */
         @Test
         public void IntegrationPlane3Test()
         {
            Plane pl = new Plane(new Point(-1,-20,-10), new Point(0,0,10), new Point(1,-20,-10));
            int count = 0;

            for(int i = 0;i < Nx;i++)
            {
               for(int j = 0;j < Ny;j++)
               {
                  Ray r = cam1.constructRayThroughPixel(Nx,Ny,j,i,screenDistance,screenWidth,screenHeight);
                  List<Point> listPoints = pl.findIntersections(r);
                  count += (listPoints != null ? listPoints.size() : 0);
               }
            }

            assertEquals("ERROR - INTEGRATION PLANE FAILED ON 6 INTERSECTIONS", 6, count);

         }

   }

