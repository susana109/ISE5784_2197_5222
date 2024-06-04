package geometries;
import primitives .*;
/**
 * Geometry interface defines a common behavior for geometric objects.
 * All geometric objects must be able to return the normal vector at a given point.
 */
public interface Geometry extends Intersectable{
    /**
     * Returns the normal vector to the geometry at a given point.
     *
     * @param point the point on the geometry
     * @return the normal vector at the given point
     */
    public Vector getNormal(Point point);

}