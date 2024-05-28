package geometries;

import primitives.*;

/**
 * The Tube class represents a tube in 3D space.
 * A tube is defined by a central axis (a Ray) and a radius.
 */
public class Tube extends RadialGeometry {
    /** The central axis of the tube */
    protected final Ray axis;

    /**
     * Constructs a Tube with a given axis and radius.
     *
     * @param axis the central axis of the tube
     * @param radius the radius of the tube
     */
    public Tube(Ray axis, double radius) {
        super(radius);
        this.axis = axis;

    }

    /**
     * Returns the normal vector to the tube at a given point.
     *
     * @param point the point on the tube
     * @return the normal vector at the given point
     */
    public Vector getNormal(Point point) {
        // Get the point on the axis (projection of the point onto the axis)
        Point p0 = axis.getHead();
        Vector v = axis.getDirection();

        // Calculate t such that the projection of the point onto the axis is p0 + t * v
        Vector p0ToPoint = point.subtract(p0);
        double t = v.dotProduct(p0ToPoint);

        // Calculate the closest point on the axis
        Point o = p0.add(v.scale(t));

        // Calculate the normal vector
        Vector normal = point.subtract(o).normalize();

        return normal;
    }
}

