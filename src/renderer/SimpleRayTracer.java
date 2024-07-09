package renderer;

import primitives.Color;
import primitives.*;
import scene.Scene;
import java.util.*;

public class SimpleRayTracer extends RayTracerBase {


    public SimpleRayTracer(Scene scene) {
        super(scene);
    }


    public Color traceRay(Ray ray) {
        List<Point> intersections = scene.geometries.findIntersections(ray);
        //if there is no intersections return scene background;
        if(intersections==null)
            return scene.background;
        else {
        Point closestPoint = ray.findClosestPoint(intersections);
    return calcColor(closestPoint);
     }
    }
    private Color calcColor(Point point) {
        return scene.ambientLight.getIntensity();
    }

}