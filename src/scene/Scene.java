package scene;

import geometries.Geometries;
import geometries.Intersectable;
import lighting.AmbientLight;
import primitives.Color;
import primitives.Ray;

import java.util.List;

public class Scene {

    public Geometries geometries;
    public String Name;
    public Color background=Color.BLACK;
    public AmbientLight ambientLight= AmbientLight.NONE;


    public Scene(String sceneName){
        this.Name = sceneName;
    }

    public Scene setAmbientLight(AmbientLight ambientLight) {
        this.ambientLight = ambientLight;
        return this;
    }

    public Scene setBackground(Color background) {
        this.background = background;
        return this;
    }

    public Scene setGeometries(Geometries geometries) {
        this.geometries = geometries;
        return this;
    }


    public List<Intersectable> findIntersections(Ray ray) {
    }
}
