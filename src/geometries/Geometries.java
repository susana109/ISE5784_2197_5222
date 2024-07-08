package geometries;


import primitives.Point;
import primitives.Ray;

import java.util.*;
import java.util.ArrayList;



public class Geometries implements Intersectable{
   private final List<Intersectable> geometries = new LinkedList<Intersectable>();

    public Geometries(){
    }

    public Geometries(Intersectable... geometries){
        add(geometries);
    }

    public void add(Intersectable... geometries){
        Collections.addAll(this.geometries, geometries);
        }

    /**
     * calculate the points of the intersections with the given ray to the collections of geometries
     * @param ray Ray which should intersect with the geometries
     * @return List Point which should return null on none point, or list of points that intersect the geometries
     */
    @Override
    public List<Point> findIntersections(Ray ray) {
        List<Point> intersections = null;
        for (Intersectable geometry : geometries) {
            var geometryIntersections = geometry.findIntersections(ray);
            if (geometryIntersections != null) {
                if (intersections == null)
                    intersections = new LinkedList<>(geometryIntersections);
                else
                    intersections.addAll(geometryIntersections);
            }
        }
        return intersections;
    }

    @Override
    public double getDistance() {
        return 0;
    }

    @Override
    public Point getPoint() {
        return null;
    }

}
