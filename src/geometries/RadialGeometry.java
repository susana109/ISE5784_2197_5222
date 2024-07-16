package geometries;

/**
 * RadialGeometry is an abstract class representing geometric objects with a radius.
 * Implements the Geometry interface.
 */

public abstract class RadialGeometry extends Geometry {
    /**
     * The radius of the geometry
     */
    protected final double radius;

    /**
     * Radius squared of the geometric body
     */
    protected final double radiusSquared;

    /**
     * Constructs a RadialGeometry with a given radius.
     *
     * @param radius the radius of the geometry
     */

    protected RadialGeometry(double radius) {
        this.radius = radius;
        radiusSquared = radius * radius;
    }
}
