package geometries;

import primitives.*;

import java.util.List;

/**
 * Triangle class represents a triangle in 3D Cartesian coordinate system.
 * It inherits from the Polygon class.
 */
public  class Triangle extends Polygon {

    public Triangle(Point a, Point b, Point c) {
        super(a,b,c);
    }
}

