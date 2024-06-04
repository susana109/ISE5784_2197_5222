package primitives;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

class VectorTest {

    /**
     * Test method for {@link primitives.Vector#add(primitives.Vector)}.
     */
    @org.junit.jupiter.api.Test
    void testAdd() {
        Vector v1 = new Vector(1, 2, 3);
        Vector v1Opposite = new Vector(-1, -2, -3);
        Vector v2 = new Vector(-2, -4, -6);
        // ============ Equivalence Partitions Tests ==============
        // TC01: Test that addition of two vectors with positives and negatives coordinates
        assertEquals(new Vector(1, 1, 1),
                v1.add(v1Opposite),
                "ERROR: Vector + -itself does not throw an exception");
        // TC02: Test addition of two positive vectors
        assertNotEquals(v1.add(v2), v1Opposite, "ERROR: Vector + Vector does not work correctly");
    }

    /**
     * Test method for {@link primitives.Vector#scale(double)}.
     */
    @org.junit.jupiter.api.Test
    void testScale() {
    }

    /**
     * Test method for {@link primitives.Vector#dotProduct(primitives.Vector)}.
     */
    @org.junit.jupiter.api.Test
    void testDotProduct() {
        Vector v1 = new Vector(1, 2, 3);
        Vector v2 = new Vector(-2, -4, -6);
        Vector v3 = new Vector(0, 3, -2);
        // ============ Equivalence Partitions Tests ==============
        // TC03: Test if dot product of orthogonal vectors is zero
        assertEquals(0.0,
                v1.dotProduct(v3),
                0.001,
                "ERROR: dotProduct() for orthogonal vectors is not zero");
        // TC04: Test that value of dot-product is proper
        assertEquals(-28,
                v1.dotProduct(v2),
                0.01, "ERROR: dotProduct() wrong value");
    }

    /**
     * Test method for {@link primitives.Vector#crossProduct(primitives.Vector)}.
     */
    @org.junit.jupiter.api.Test
    void testCrossProduct() {
        Vector v1 = new Vector(1, 2, 3);

        // ============ Equivalence Partitions Tests ==============

        Vector v2 = new Vector(0, 3, -2);
        Vector vr = v1.crossProduct(v2);

        // TC01: Test that length of cross-product is proper (orthogonal vectors taken
        // for simplicity)
        assertEquals(v1.length() * v2.length(), vr.length(), 0.00001, "crossProduct() wrong result length");

        // TC02: Test cross-product result orthogonality to its operands
        assertEquals(0, vr.dotProduct(v1), "crossProduct() result is not orthogonal to 1st operand");
        assertEquals(0, vr.dotProduct(v2), "crossProduct() result is not orthogonal to 2nd operand");

        // =============== Boundary Values Tests ==================
        // TC11: test zero vector from cross-product of co-lined vectors
        Vector v3 = new Vector(-2, -4, -6);
        assertThrows(IllegalArgumentException.class, () -> v1.crossProduct(v3),
                "crossProduct() for parallel vectors does not throw an exception");
    }

    /**
     * Test method for {@link primitives.Vector#lengthSquared()}.
     */
    @org.junit.jupiter.api.Test
    void testLengthSquared() {
        Vector v4 = new Vector(1, 2, 2);
        // ============ Equivalence Partitions Tests ==============
        // TC01: Test that value of the squared length of the vector is proper
        assertEquals(9,
                v4.lengthSquared(),
                0.001,
                "ERROR: lengthSquared() wrong value");
    }

    /**
     * Test method for {@link primitives.Vector#length()}.
     */
    @org.junit.jupiter.api.Test
    void testLength() {
        Vector v4 = new Vector(1, 2, 2);
        // ============ Equivalence Partitions Tests ==============
        // TC01: Test that value of length of the vector is proper
        assertEquals(3, v4.length(), 0.001, "ERROR: length() wrong value");
    }

    /**
     * Test method for {@link primitives.Vector#normalize()}.
     */
    @org.junit.jupiter.api.Test
    void testNormalize() {
        Vector v = new Vector(1, 2, 3);
        Vector u = v.normalize();
        // ============ Equivalence Partitions Tests ==============
        // TC01: Test if the length of the normalized vector is 1
        assertEquals(0,
                u.length() - 1,
                0.001, "ERROR: the normalized vector is not a unit vector");
        // TC02: Test if the normalized vector is parallel to the original one
        assertTrue(v.crossProduct(u).equals(Double3.ZERO),
                "ERROR: the normalized vector is not parallel to the original one");
        // TC03: Test if the normalized vector and the original one has the same direction
        assertEquals(0, v.dotProduct(u) < 0,
                "ERROR: the normalized vector is opposite to the original one");
    }
}
