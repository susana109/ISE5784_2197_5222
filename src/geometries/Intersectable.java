package geometries;

import java.util.List;

public interface Intersectable {
    List<Point> findIntersections(Ray ray);
}
