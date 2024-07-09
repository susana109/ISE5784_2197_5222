package primitives;

import java.util.Objects;

/**
 * Class Point represents a point in a 3D space.
 * It is defined by its coordinates in a Double3 object.
 */
public class Point {
    /** A constant representing the origin point (0, 0, 0). */
    public static final Point ZERO = new Point(Double3.ZERO);
    /** The coordinates of the point. */
    final protected Double3 xyz;

    /**
     * Constructor to initialize a Point object with three coordinates.
     * @param x the x-coordinate
     * @param y the y-coordinate
     * @param z the z-coordinate
     */
    public Point(double x, double y, double z) {
        xyz = new Double3(x, y, z);
    }

    /**
     * Constructor to initialize a Point object with a Double3 object.
     * @param xyz the Double3 object representing the coordinates
     */
    public Point(Double3 xyz) {
        this.xyz = xyz;
    }

    /**
     * Checks whether this point is equal to another object.
     * @param o the object to compare with
     * @return true if the points are equal, false otherwise
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Point)) return false;
        Point point = (Point) o;
        return Objects.equals(xyz, point.xyz);
    }

    /**
     * Returns the hash code of this point.
     * @return the hash code
     */
    @Override
    public int hashCode() {
        return Objects.hash(xyz);
    }

    /**
     * Returns a string representation of this point.
     * @return the string representation
     */
    @Override
    public String toString() {
        return "Point{" +
                "xyz=" + xyz +
                '}';
    }

    /**
     * Adds a vector to this point and returns the resulting point.
     * @param v1 the vector to add
     * @return the resulting point
     */
    public Point add(Vector v1) {
        return new Point(xyz.add(v1.xyz));
    }

    /**
     * Calculates the squared distance between this point and another point.
     * @param p1 the other point
     * @return the squared distance
     */
    public double distanceSquared(Point p1) {
        return (p1.xyz.d1 - this.xyz.d1) * (p1.xyz.d1 - this.xyz.d1) +
                (p1.xyz.d2 - this.xyz.d2) * (p1.xyz.d2 - this.xyz.d2) +
                (p1.xyz.d3 - this.xyz.d3) * (p1.xyz.d3 - this.xyz.d3);
    }

    /**
     * Computes the distance between this point and another point.
     * @param p1 the other point
     * @return the distance
     */
    public double distance(Point p1) {
        return Math.sqrt(distanceSquared(p1));
    }

    /**
     * Subtracts another point from this point and returns the resulting vector.
     * @param p1 the other point
     * @return the resulting vector
     */
    public Vector subtract(Point p1) {
        return new Vector(xyz.subtract(p1.xyz));
    }
    public double getX(){
        return this.xyz.d1;
    }
    public double getY(){
        return this.xyz.d2;
    }
}
