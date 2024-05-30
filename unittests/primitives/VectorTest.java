package primitives;

import static org.junit.jupiter.api.Assertions.*;

class VectorTest {

    @org.junit.jupiter.api.Test
    void testAdd() {
        Vector v1         = new Vector(1, 2, 3);
        Vector v1Opposite = new Vector(-1, -2, -3);
        Vector v2         = new Vector(-2, -4, -6);
        assertEquals(new Vector(1,1,1), v1.add(v1Opposite),"ERROR: Vector + -itself does not throw an exception");
        assertNotEquals(v1.add(v2), v1Opposite, "ERROR: Vector + Vector does not work correctly");
    }

    @org.junit.jupiter.api.Test
    void testScale() {
    }

    @org.junit.jupiter.api.Test
    void testDotProduct() {
        Vector v1         = new Vector(1, 2, 3);
        Vector v2         = new Vector(-2, -4, -6);
        Vector v3         = new Vector(0, 3, -2);
        assertEquals(0.0,
                v1.dotProduct(v3),
                0.001,
                "ERROR: dotProduct() for orthogonal vectors is not zero");
        assertEquals(-28,
                v1.dotProduct(v2) ,
                0.01,"ERROR: dotProduct() wrong value");
    }

    @org.junit.jupiter.api.Test
    void testCrossProduct() {
        Vector v1         = new Vector(1, 2, 3);
        Vector v2         = new Vector(-2, -4, -6);
        Vector v3         = new Vector(0, 3, -2);
        Vector vr = v1.crossProduct(v3);
        /*assertEquals(new Vector (1,1,1), v1.crossProduct(v2),
                "ERROR: crossProduct() for parallel vectors does not throw an exception");
        assertEquals(new Vector (1,1,1), vr.length() - v1.length() * v3.length(),
                "ERROR: crossProduct() wrong result length");*/
        assertEquals(0,vr.dotProduct(v1) , "ERROR: crossProduct() result is not orthogonal to its operands");
        assertEquals(0,vr.dotProduct(v3),"ERROR: crossProduct() result is not orthogonal to its operands");

    }

    @org.junit.jupiter.api.Test
    void testLengthSquared() {
        Vector v4         = new Vector(1, 2, 2);
        assertEquals(9,
                v4.lengthSquared(),
                0.001,
                "ERROR: lengthSquared() wrong value");
    }

    @org.junit.jupiter.api.Test
    void testLength() {
        Vector v4         = new Vector(1, 2, 2);
        assertEquals(3, v4.length(),0.001,"ERROR: length() wrong value");
    }

    @org.junit.jupiter.api.Test
    void testNormalize() {
        Vector v = new Vector(1, 2, 3);
        Vector u = v.normalize();
        assertEquals(0, u.length()-1, 0.001,"ERROR:the normalized vector is not a unit vector");
      /*  assertEquals(new Vector(1,1,1), v.crossProduct(u),
                "ERROR: the normalized vector is not parallel to the original one");
        assertEquals(null, v.dotProduct(u) < 0,
                "ERROR: the normalized vector is opposite to the original one");*/
    }
}