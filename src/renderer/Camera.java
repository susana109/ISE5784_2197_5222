package renderer;

import primitives.*;
import java.util.MissingResourceException;


public class Camera implements Cloneable {
    private  Vector vTo;
    private  Vector vUp;
    private  Point p0;
    private  Vector vRight;
    private double distance=0;
    private double width=0;
    private double height=0;

    public Camera(Point p0, Vector vTo, Vector vUp) {
        this.vTo = vTo;
        this.vUp = vUp;
        this.p0 = p0;

        vRight = vTo.crossProduct(vUp).normalize();

    }

    public Camera setViewPlaneDistance(int distance) {
        this.distance = distance;
        return this;
    }

    public Camera setViewPlaneSize(int width, int height) {
        this.width = width;
        this.height = height;
        return this;
    }

    public Ray constructRay(int nX, int nY, int j, int i) {
        return null;
    }
    public static Builder getBuilder(Camera camera)
    {
        return new Builder(camera);
    }
    public static class Builder {
        private final Camera camera;

        /**
         * Constructor for Builder class
         * @param camera
         */
        public Builder(Camera camera) {
            //IllegalArgumentException
            this.camera = camera;
        }
        public Builder getLocation(Point location){
            //IllegalArgumentException
            camera.p0=location;
          return this;
        }
        public Builder  setDirection(Vector vTo, Vector vUp){
            if(vTo.getX()==0 && vUp.getX()==0) {
                camera.vTo = vTo.normalize();
                camera.vUp = vUp.normalize();
                return this;
            }
            else
                throw new IllegalArgumentException("The 2 vectors are not verticals");
        }
        public Builder setVpSize(double width, double height){
            //IllegalArgumentException
            camera.width = width;
            camera.height = height;
            return this;
        }
        public Builder setVpDistance(double distance) {
            //IllegalArgumentException
            camera.distance=distance;
            return this;
        }
            public Camera build() throws CloneNotSupportedException {
                if (camera.p0 == null) throw new MissingResourceException(" Rendering data is missing","Camera","p0");
                if (camera.vUp == null) throw new MissingResourceException(" Rendering data is missing","Camera","vUp");
                if (camera.vTo == null) throw new MissingResourceException(" Rendering data is missing","Camera","vTo");
                if (camera.vRight == null) throw new MissingResourceException(" Rendering data is missing","Camera","vRight");
                if (Util.alignZero(camera.width) <= 0) throw new IllegalArgumentException("Width is negative or equals zero") ;
                if (Util.alignZero(camera.height) <= 0) throw new IllegalArgumentException("Height is negative or equals zero") ;
                if (Util.alignZero(camera.distance) <= 0) throw new IllegalArgumentException("Distance is negative or equals zero") ;
                if (!Util.isZero(camera.vRight.dotProduct(camera.vTo)))throw new IllegalArgumentException("vRight and vTo are orthogonal");
                camera.vRight = camera.vTo.crossProduct(camera.vUp).normalize();
                return (Camera) camera.clone();// Cloneable – get a full copy
            
        }
    }


}
