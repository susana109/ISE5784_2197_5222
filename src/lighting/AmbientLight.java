package lighting;

import primitives.Color;
import primitives.Double3;

public class AmbientLight {

    private final Color intensity;

    public AmbientLight(Color intensity, Double3 double3) {
        this.intensity = intensity;
    }
}
