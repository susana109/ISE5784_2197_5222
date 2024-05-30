package primitives;

import static org.junit.jupiter.api.Assertions.*;

class PointTest {

    @org.junit.jupiter.api.Test
    void testAdd() {

            // ============ Equivalence Partitions Tests ==============
            Point p1 = new Point(1, 2, 3);
            Vector v1 = new Vector(1, 2, 3);

            // Check if the addition of the vector to the point produces the correct result
            assertEquals(new Point(2, 4, 6), p1.add(v1), "ERROR: Point + Vector does not work correctly");
        }

    @org.junit.jupiter.api.Test
    void testDistanceSquared() {
        // ============ Equivalence Partitions Tests ==============
        Point p1 = new Point(1, 2, 3);
        Point p3 = new Point(2, 4, 5);

        // Check if the squared distance between two points is calculated correctly
        assertEquals(9, p1.distanceSquared(p3), 0.00001,
                "ERROR: squared distance between points is wrong");
    }

    @org.junit.jupiter.api.Test
    void testDistance() {
        // ============ Equivalence Partitions Tests ==============
        Point p1 = new Point(1, 2, 3);
        Point p3 = new Point(2, 4, 5);

        // Check if the distance between two points is calculated correctly
        assertEquals(3, p1.distance(p3), 0.00001, "ERROR: distance between points is wrong");

}

    @org.junit.jupiter.api.Test
    void testSubtract() {
        // ============ Equivalence Partitions Tests ==============
        Point p1 = new Point(1, 2, 3);
        Point p3 = new Point(2, 4, 5);

        // Check if the subtraction of one point from another produces the correct vector
        assertEquals(new Vector(1, 2, 2), p3.subtract(p1),
                "ERROR: Point - Point does not work correctly");

        // =============== Boundary Values Tests ==================
        // Check if subtracting a point from itself throws an IllegalArgumentException
        assertThrows(IllegalArgumentException.class, () -> p1.subtract(p1),
                "ERROR: (point - itself) does not throw an exception");
    }
}