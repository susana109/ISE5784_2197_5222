package geometries;
import primitives .*;

import java.util.List;

/**
 * The Sphere class represents a sphere in 3D space.
 * A sphere is defined by a center point and a radius.
 */
public class Sphere extends RadialGeometry {
    /** The center point of the sphere */
    private final Point center;


    /**
     * Constructs a Sphere with a given center and radius.
     *
     * @param center the center point of the sphere
     * @param radius the radius of the sphere
     */
    public Sphere(Point center, double radius) {
        super(radius);
        this.center = center;
    }
    /**
     * Returns the normal vector to the sphere at a given point.
     *
     * @param point the point on the sphere
     * @return the normal vector at the given point
     */
    public Vector getNormal(Point point) {
        // Compute the vector from the center of the sphere to the point
        Vector normal = point.subtract(center);
        // Normalize the vector to get the normal vector
        return normal.normalize();
    }

    @Override
    public List<Point> findIntersections(Ray ray) {
        return null;
    }
}

