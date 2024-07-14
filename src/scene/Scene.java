package scene;

import geometries.Geometries;
import lighting.*;
import primitives.Color;
import java.util.LinkedList;
import java.util.List;
public class Scene {

    public Geometries geometries = new Geometries();
    public String Name;
    public Color background = Color.BLACK;
    public AmbientLight ambientLight = AmbientLight.NONE;

    /** The lights in the scene */
    public List<LightSource> lights = new LinkedList<>();

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

    /**
     * Updates the lights in the scene.
     *
     * @param lights The new list of lights.
     * @return This Scene object.
     */
    public Scene setLights(List<LightSource> lights) {
        this.lights = lights;
        return this;
    }

}
