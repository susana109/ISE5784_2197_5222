package geometries;

import primitives.Point;
import primitives.Ray;
import primitives.Vector;

/**
 * The Cylinder class represents a cylinder in 3D space.
 * A cylinder is defined by a central axis (a Ray), a radius, and a height.
 */
public class Cylinder extends Tube {
    /**
     * The height of the cylinder
     */
    private double height;


    /**
     * Constructs a Cylinder with a given axis, radius, and height.
     *
     * @param axis   the central axis of the cylinder
     * @param radius the radius of the cylinder
     * @param height the height of the cylinder
     */
    public Cylinder(Ray axis, double radius, double height) {
        super(radius,axis);
        this.height = height;
    }

    /**
     * Returns the normal vector to the cylinder at a given point.
     *
     * @param point the point on the cylinder
     * @return the normal vector at the given point
     */
    public Vector getNormal(Point point) {
        return null;
    }

}
