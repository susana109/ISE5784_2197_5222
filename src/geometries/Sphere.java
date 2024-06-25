package geometries;
import primitives .*;
import static primitives.Util.alignZero;
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


    /**
     * calculates the points of the intersections with the given ray to the sphere
     * @param ray Ray which should intersect with the sphere
     * @return List Point which should return null on none point, or list of points that intersect the sphere
     */

    @Override
    public List<Point> findIntersections(Ray ray) {
        Point p0 = ray.getHead();
        Vector v = ray.getDirection();
        Vector u;


        // Calculates the vector from the head of the ray to the center of the sphere
        u = this.center.subtract(p0);

        // Check if p0 is equal to the center of the sphere
        if (this.center.equals(p0)) {
            // p0 is equal to the center of the sphere, return the intersection point
            return List.of(ray.getPoint(this.radius));
        }

// Continue with the rest of your code...

        //calculates tm the projection of u on v (alignZero is used for accuracy)
        double tm = alignZero(v.dotProduct(u));

        //calculates the distance squared of p0 from the center of the sphere
        //if tm=0, v is orthogonal to u
        //if not, calculates dsquared with the Pythagore's theorem
        double dSquared = (tm == 0) ? u.lengthSquared() : u.lengthSquared() - tm * tm;

        //calculates the squared distance from tm to the sphere
        double thSquared = alignZero(this.radius *this.radius - dSquared);

        //if it's negative , there is no intersection point
        if (thSquared <= 0) return null;

        double th = alignZero(Math.sqrt(thSquared));//distances to the intersection points
        if (th == 0) return null;// the ray is tangent to the sphere

        //distances of intersection points on the ray
        double t1 = alignZero(tm - th);
        double t2 = alignZero(tm + th);

        //if the points are before the head of the ray there is no intersection points
        if (t1 <= 0 && t2 <= 0) return null;

        //if the points are after the head of the ray it returns the points
        if (t1 > 0 && t2 > 0) return List.of(ray.getPoint(t1), ray.getPoint(t2)); //P1 , P2
        if (t1 > 0)
            return List.of(ray.getPoint(t1));
        else
            return List.of(ray.getPoint(t2));
    }
}