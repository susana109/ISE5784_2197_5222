package primitives;

import java.util.Objects;

/**
 * Class Point represents a point in a 3D space.
 * It is defined by its coordinates in a Double3 object.
 */
public class Point {
    public static final Point ZERO = new Point(Double3.ZERO);
    final protected Double3 xyz ;

    /**
     * Constructor to initialize a Point object with three coordinates.
     * @param x
     * @param y
     * @param z
     */
    public Point(double x, double y, double z) {
        xyz = new Double3 (x,y,z);

    }

    /**
     Constructor to
     initialize a
     Point object
     with an object type Double 3
     * @param double3
     */
    public Point (Double3  double3){
        this.xyz=double3;
    }




    public boolean equals(Object o) {
        boolean result;
        if (this == o) {
            result = true;
        } else if (!(o instanceof Point point)) result = false;
        else {
            result = (o instanceof Point) && Objects.equals(xyz, point.xyz);
        }
        return result;
    }


    public int hashCode() {
        return Objects.hashCode(xyz);
    }

    public String toString() {
        return "Point{" +
                "xyz=" +xyz +
                '}';
    }

    /**
     * Adds a vector to this point and returns the resulting point.
     * @param v1 the vector to add
     * @return the resulting point
     */
    public Point add(Vector v1) {
        return new Point(xyz. add (v1.xyz));
    }
    /**
     * Calculates the squared distance between this point and another point.
     * @param p1 the other point
     * @return the squared distance
     */
    public double distanceSquared(Point p1) {
        double i = (p1.xyz.d1 - this.xyz.d1)*(p1.xyz.d1 - this.xyz.d1)  + (p1.xyz.d2 - this.xyz.d2) *(p1.xyz.d2 - this.xyz.d2)
                + (p1.xyz.d3 - this.xyz.d3)*(p1.xyz.d3 - this.xyz.d3);
        return i;
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
}
