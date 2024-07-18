package myscene;
import static java.awt.Color.*;

import org.junit.jupiter.api.Test;

import geometries.*;
import lighting.*;
import primitives.*;
import renderer.Camera;
import renderer.ImageWriter;
import renderer.SimpleRayTracer;
import scene.*;
public class MySceneTest {

    private final Scene scene = new Scene("My Scene");
    ImageWriter imageWriter = new ImageWriter("trianglesMultipleLights", 500, 500);

    Camera camera = Camera.getBuilder()
            .setLocation(new Point(0, 0, 100))
            .setDirection(new Vector(0, 0, -1), new Vector(0, 1, 0))
            .setVpSize(200, 200)
            .setVpDistance(100)
            .setImageWriter(imageWriter)
            .setRayTracer(new SimpleRayTracer(scene))
            .build();
    @Test
    public void twoTriangles (){
        scene.geometries.add(
            new Triangle(new Point(-150, -150, -115), new Point(150, -150, -135),
                    new Point(75, 75, -150))
                    .setMaterial(new Material().setkD(0.5).setkS(0.5).setnShininess(60)),
            new Triangle(new Point(-150, -150, -115), new Point(-70, 70, -140), new Point(75, 75, -150))
                    .setMaterial(new Material().setkD(0.5).setkS(0.5).setnShininess(60)));
        scene.setAmbientLight(new AmbientLight(new Color(RED), 0));
        scene.lights.add(new SpotLight(new Color(133, 534, 200), new Point(60, 60, 100), new Vector(-1,-1,-2))
                .setkL(0.0001).setkQ(0.000005));
        scene.lights.add(new PointLight(new Color(890, 456, 675), new Point(-50, -50, -50))
                .setkL(0.0005).setkQ(0.0005));
        scene.lights.add(new DirectionalLight(new Color(121, 123, 324), new Vector(0, 0, -1)));

        camera.renderImage();
        camera.writeToImage();

    }
}

