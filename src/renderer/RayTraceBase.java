package renderer;

import scene.Scene;
import primitives.*;


public abstract class RayTraceBase {

    protected final Scene scene;


    public RayTraceBase(Scene scene) {
        this.scene = scene;
    }



    abstract public Color traceRay(Ray ray);
}


