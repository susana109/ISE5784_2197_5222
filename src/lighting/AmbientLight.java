package lighting;

import primitives.Color;
import primitives.Double3;

public class AmbientLight {

    private final Color intensity;

   public AmbientLight(Color intensity,Double3 attenuation) {
       this.intensity=intensity;}
    public AmbientLight(Color intensity,double attenuation) {
        this.intensity=intensity;}

    public static final AmbientLight NONE= new AmbientLight(Color.BLACK, Double3.ZERO);

   public Color getIntensity(){
       return this.intensity;
   }

}
