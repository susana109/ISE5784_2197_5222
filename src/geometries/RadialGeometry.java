package geometries;
/**
 * RadialGeometry is an abstract class representing geometric objects with a radius.
 * Implements the Geometry interface.
 */

public abstract class RadialGeometry implements Geometry {
    /** The radius of the geometry */
    protected final double radius;

    /**
     * Constructs a RadialGeometry with a given radius.
     *
     * @param radius the radius of the geometry
     */

    protected RadialGeometry(double radius) {
        this.radius = radius;
    }
}
