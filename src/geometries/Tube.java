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



        // Get the point on the axis (projection of the point onto the axis)
       /* Point p0 = axis.getHead();
        Vector v = axis.getDirection();

        // Calculate t such that the projection of the point onto the axis is p0 + t * v
        Vector p0ToPoint = point.subtract(p0);

        double projection = p0ToPoint.dotProduct(v);

        // Calculate the closest point on the axis


            // projection of P-O on the ray:
           Point p1 = p0.add(v.scale(projection));

        //Point o = v.add(v.scale(t));

        // Calculate the normal vector
        return point.subtract(p1).normalize();*/

    }

    @Override
    public List<Point> findIntersections(Ray ray) {
        return null;
    }
}

