package primitives;

import java.util.Objects;

/**
 * Class Vector represents a vector in a 3D space.
 * It extends the Point class to leverage its coordinate storage.
 */
public class Vector extends Point {
    /**
     * Constructor to initialize a Vector object with three coordinates.
     *
     * @param x
     * @param y
     * @param z
     */
    public Vector(double x, double y, double z) {
        super(x, y, z);
        if (this.xyz.equals(Double3.ZERO))
            throw new IllegalArgumentException("Cannot have a zero vector");


    }

    /**
     * Constructor to initialize a Vector object with a Double3 object.
     *
     * @param xyz
     */
    public Vector(Double3 xyz) {
        super(xyz);
        if (this.xyz.equals(Double3.ZERO)) {
            throw new IllegalArgumentException("Cannot have a zero vector");
        }
    }


    public String toString() {
        return super.toString();
    }

    public boolean equals(Object o) {
        boolean result;
        if (this == o) {
            result = true;
        } else if (!(o instanceof Vector vector)) result = false;
        else {
            result = (o instanceof Vector) && Objects.equals(xyz, vector.xyz);
        }
        return result;
    }

    /**
     * Adds another vector to this vector and returns the resulting vector.
     *
     * @param v the vector to add
     * @return the resulting vector
     */
    public Vector add(Vector v) {
        Vector result = new Vector(this.xyz.add(v.xyz));
        if (result.equals(ZERO)) { // Assuming ZERO is a constant zero vector
            throw new IllegalArgumentException("Cannot have a zero vector");
        }
        return result;
    }

    /**
     * Scales this vector by a scalar and returns the resulting vector.
     *
     * @param d the scalar to scale by
     * @return the resulting vector
     */
    public Vector scale(double d) {
        return new Vector(this.xyz.scale(d));
    }

    /**
     * Computes the dot product of this vector and another vector.
     *
     * @param v the other vector
     * @return the dot product
     */
    public double dotProduct(Vector v) {
        return this.xyz.d1 * v.xyz.d1 + this.xyz.d2 * v.xyz.d2 + this.xyz.d3 * v.xyz.d3;
    }

    /**
     * Computes the cross product of this vector and another vector.
     *
     * @param v the other vector
     * @return the resulting vector
     */
    public Vector crossProduct(Vector v) {
        double x = (this.xyz.d2 * v.xyz.d3) - (this.xyz.d3 * v.xyz.d2);
        double y = (this.xyz.d3 * v.xyz.d1) - (this.xyz.d1 * v.xyz.d3);
        double z = (this.xyz.d1 * v.xyz.d2) - (this.xyz.d2 * v.xyz.d1);
        return new Vector(x, y, z);
    }

    /**
     * Computes the squared length of this vector.
     *
     * @return the squared length
     */
    public double lengthSquared() {
        return (this.xyz.d1 * this.xyz.d1) + (this.xyz.d2 * this.xyz.d2) + (this.xyz.d3 * this.xyz.d3);
    }

    /**
     * Computes the length of this vector.
     *
     * @return the length
     */
    public double length() {
        return Math.sqrt(this.lengthSquared());
    }

    /**
     * Normalizes this vector and returns the resulting unit vector.
     *
     * @return the normalized vector
     */
    public Vector normalize() {
        double x = this.xyz.d1 / this.length();
        double y = this.xyz.d2 / this.length();
        double z = this.xyz.d3 / this.length();
        return new Vector(x, y, z);
    }
}

