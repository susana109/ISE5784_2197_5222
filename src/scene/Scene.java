package scene;

import geometries.Geometries;
import lighting.AmbientLight;
import primitives.Color;

public class Scene {

    public Geometries geometries = new Geometries();
    public String Name;
    public Color background = Color.BLACK;
    public AmbientLight ambientLight = AmbientLight.NONE;


    public Scene(String sceneName) {
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


}
