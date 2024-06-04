package geometries;

import primitives.*;

import java.util.List;


/**
 * Plane class represents a 3-dimensional plane.
 * A plane is defined by a point and a normal vector.
 */

public class Plane implements Geometry {
    /** A point on the plane */
    private Point q0;
    /** The normal vector to the plane */
    private  Vector normal;

    /**
     *Constructs a Plane from three points.
     *      * The plane is defined by the three points, and the normal vector is calculated.
     * @param p1
     * @param p2
     * @param p3
     */
    public Plane(Point p1, Point p2, Point p3) {
        this.q0 = p1;
        this.normal  = (p1.subtract(p2).crossProduct(p2.subtract(p3))).normalize();

    }
    /**
     * Constructs a Plane from a point and a normal vector.
     *
     * @param q0 the point on the plane
     * @param v the normal vector to the plane
     */

    public Plane(Point q0, Vector v){
        this.q0 = q0;
        this.normal=v.normalize();

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

    @Override
    public List<Point> findIntersections(Ray ray) {
        return null;
    }
}