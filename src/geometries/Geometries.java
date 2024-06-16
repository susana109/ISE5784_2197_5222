package geometries;


import primitives.Point;
import primitives.Ray;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

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
