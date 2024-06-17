package geometries;
import primitives .*;
import static primitives.Util.alignZero;
import java.util.List;

public class Sphere extends RadialGeometry{
    private final Point center;

    public Sphere(Point center, double radius){
        super(radius);
        this.center = center;
}

public Vector getNormal(Point point){
    Vector normal = point.subtract(center);
    return normal.normalize();
    }

@Override
public List<Point> findIntersections(Ray ray) {
    Point p0 = ray.getHead();
    Vector v = ray.getDirection();
    Vector u;
    try {
        u = (this.center).subtract(p0); // p0 == _center
    } catch (IllegalArgumentException e) {
        return List.of(ray.getPoint(radius));
    }
    double tm = alignZero(v.dotProduct(u));
    double dSquared = (tm == 0) ? u.lengthSquared() : u.lengthSquared() - tm * tm;
    double thSquared = alignZero(radius * radius - dSquared);

    if (thSquared <= 0) return null;

    double th = alignZero(Math.sqrt(thSquared));
    if (th == 0) return null;

    double t1 = alignZero(tm - th);
    double t2 = alignZero(tm + th);
    if (t1 <= 0 && t2 <= 0) return null;
    if (t1 > 0 && t2 > 0) return List.of(ray.getPoint(t1), ray.getPoint(t2)); //P1 , P2
    if (t1 > 0)
        return List.of(ray.getPoint(t1));
    else
        return List.of(ray.getPoint(t2));
}
}