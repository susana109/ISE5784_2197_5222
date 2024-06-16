package geometries;

import primitives.*;

import java.util.List;

import static primitives.Util.isZero;

/**
 * Triangle class represents a triangle in 3D Cartesian coordinate system.
 * It inherits from the Polygon class.
 */
public  class Triangle extends Polygon {

    public Triangle(Point a, Point b, Point c) {
        super(a,b,c);
    }
    @Override
    public List<Point> findIntersections(Ray ray) {
        List<Point> intersections = plane.findIntersections(ray);
        if (intersections == null) return null;

        Point p0 = ray.getHead();
        Vector v = ray.getDirection();

        Vector v1 = vertices.get(0).subtract(p0);
        Vector v2 = vertices.get(1).subtract(p0);
        Vector v3 = vertices.get(2).subtract(p0);

        double s1 = v.dotProduct(v1.crossProduct(v2));
        if (isZero(s1)) return null;
        double s2 = v.dotProduct(v2.crossProduct(v3));
        if (isZero(s2)) return null;
        double s3 = v.dotProduct(v3.crossProduct(v1));
        if (isZero(s3)) return null;

        return ((s1 > 0 && s2 > 0 && s3 > 0) || (s1 < 0 && s2 < 0 && s3 < 0)) ? intersections : null;


    }
}

