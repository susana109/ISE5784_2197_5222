package geometries;

import primitives.*;

import java.util.List;

import static primitives.Util.isZero;

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
        this.axis= axis;

    }

    /**
     * Returns the normal vector to the tube at a given point.
     *
     * @param point the point on the tube
     * @return the normal vector at the given point
     */

    public Vector getNormal(Point point) {
        Point p0= this.axis.getHead();
        Vector v=point.subtract(p0);
        double t=(this.axis.getDirection()).dotProduct(v);
        Point O=p0.add((this.axis.getDirection()).scale(t));
        Vector normal=(point.subtract(O)).normalize();
        return normal;



    }

    @Override
    public List<Point> findIntersections(Ray ray) {
        return null;
    }
}

