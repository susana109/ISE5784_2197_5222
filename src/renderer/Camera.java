package renderer;

import primitives.*;

public class Camera {
    private final Vector vTo;
    private final Vector vUp;
    private final Point p0;
    private final Vector vRight;
    private int distance;
    private int width;
    private int height;

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
}
