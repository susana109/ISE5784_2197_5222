package geometries;

import primitives.*;

import java.util.List;

import static primitives.Util.isZero;

/**
 * Triangle class represents a triangle in 3D Cartesian coordinate system.
 * It inherits from the Polygon class.
 */

        public class Triangle extends Polygon {

            /**
             * Constructs a Triangle with the given vertices.
             *
             * @param a the first vertex of the triangle
             * @param b the second vertex of the triangle
             * @param c the third vertex of the triangle
             */
            public Triangle(Point a, Point b, Point c) {
                super(a, b, c);
            }

            /**
             * Finds the intersections of the given ray with the triangle.
             * This method overrides the method in the Polygon class to provide specific behavior for triangles.
             *
             * @param ray the ray to check for intersections with the triangle
             * @return a list of intersection points if there are any; otherwise, null
             */
            @Override
            public List<Point> findIntersections(Ray ray) {
                // Find intersections with the plane in which the triangle lies
                List<Point> intersections = plane.findIntersections(ray);
                // If there are no intersections with the plane, return null
                if (intersections == null) return null;

                // Get the head (origin) and direction of the ray
                Point p0 = ray.getHead();
                Vector v = ray.getDirection();

                // Calculate vectors from the ray origin to each vertex of the triangle
                Vector v1 = vertices.get(0).subtract(p0);
                Vector v2 = vertices.get(1).subtract(p0);
                Vector v3 = vertices.get(2).subtract(p0);

                // Calculate the dot products
                double s1 = v.dotProduct(v1.crossProduct(v2));
                if (isZero(s1)) return null;
                double s2 = v.dotProduct(v2.crossProduct(v3));
                if (isZero(s2)) return null;
                double s3 = v.dotProduct(v3.crossProduct(v1));
                if (isZero(s3)) return null;

                // Check if the intersection point is inside the triangle
                return ((s1 > 0 && s2 > 0 && s3 > 0) || (s1 < 0 && s2 < 0 && s3 < 0)) ? intersections : null;
            }
        }




