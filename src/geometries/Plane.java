package geometries;

import primitives.*;

import java.util.List;

import static primitives.Util.alignZero;
import static primitives.Util.isZero;

/**
 * Plane class represents a 3-dimensional plane.
 * A plane is defined by a point and a normal vector.
 */
public class Plane implements Geometry {
    /** A point on the plane */
    private Point q0;
    /** The normal vector to the plane */
    private Vector normal;

    /**
     * Constructs a Plane from three points.
     * The plane is defined by the three points, and the normal vector is calculated.
     * @param p1 First point
     * @param p2 Second point
     * @param p3 Third point
     */
    public Plane(Point p1, Point p2, Point p3) {
        this.q0 = p1;
        this.normal = (p1.subtract(p2).crossProduct(p2.subtract(p3))).normalize();
    }

    /**
     * Constructs a Plane from a point and a normal vector.
     *
     * @param q0 the point on the plane
     * @param v the normal vector to the plane
     */
    public Plane(Point q0, Vector v) {
        this.q0 = q0;
        this.normal = v.normalize();
    }

    /**
     * Returns the normal vector to the plane.
     *
     * @return the normal vector to the plane
     */
    public Vector getNormal() {
        return normal;
    }

    /**
     * Returns the normal vector to the plane at a given point.
     *
     * @param point the point on the plane
     * @return the normal vector to the plane
     */
    @Override
    public Vector getNormal(Point point) {
        return this.normal;
    }

    /**
     * Finds the intersections of a ray with the plane.
     *
     * @param ray the ray that intersects with the plane
     * @return a list of intersection points, or null if there are no intersections
     */
    @Override
    public List<Point> findIntersections(Ray ray) {
        Vector p0Q;
        try {
            p0Q = q0.subtract(ray.getHead());
        } catch (IllegalArgumentException e) {
            return null; // ray starts from point Q - no intersections
        }

        double nv = normal.dotProduct(ray.getDirection());
        if (isZero(nv)) { // ray is parallel to the plane - no intersections
            return null;
        }

        double t = alignZero(normal.dotProduct(p0Q) / nv);

        return t <= 0 ? null : List.of(ray.getPoint(t));
    }
}
