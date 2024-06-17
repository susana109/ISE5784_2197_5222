package geometries;


import primitives.Point;
import primitives.Ray;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
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
     * @return List Point3D which should return null on none point, or list of points that intersect the geometries
     */
    @Override
    public List<Point> findIntersections(Ray ray) {
        List<Point> intersections = null;

        for (Intersectable geo : geometries) {
            List<Point> tempIntersections = geo.findIntersections(ray);
            if (tempIntersections != null) {
                if (intersections == null)
                    intersections = new ArrayList<Point>();
                intersections.addAll(tempIntersections);
            }
        }
        return intersections;
    }

}
