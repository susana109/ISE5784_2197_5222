package geometries;

import primitives.*;


/**
 * Plane class represents a 3-dimensional plane.
 * A plane is defined by a point and a normal vector.
 */

public class Plane implements Geometry {
    /** A point on the plane */
    private final Point q0;
    /** The normal vector to the plane */
    private final Vector normal;

    /**
     *Constructs a Plane from three points.
     *      * The plane is defined by the three points, and the normal vector is calculated.
     * @param p1
     * @param p2
     * @param p3
     */
    public Plane(Point p1, Point p2, Point p3) {
        q0 = p1;
        normal  = null;

    }
    /**
     * Constructs a Plane from a point and a normal vector.
     *
     * @param q0 the point on the plane
     * @param normal the normal vector to the plane
     */

    public Plane(Point q0, Vector normal){
        this.q0 = q0;
        this.normal=normal.normalize();

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
        return normal;
    }

}