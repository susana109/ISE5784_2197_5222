package primitives;
import static primitives.Util.isZero;
import java.util.Objects;
/**
 * Class Ray is the basic class representing a fundamental object
 * in geometry. It is the collection of all the points on one side of
 * a line in one direction starting from a single point on the line.
 * Defined by a point and a direction (unit vector).
 * @author Ariella Boukobza and Bitya Susana
 */



public class Ray {
    private final Point head;
    private final Vector direction;

    /**
     *Constructor to initialize a Ray object with a starting point and a direction.
     *      * The direction vector is normalized.
     * @param head
     * @param direction
     */

    public Ray(Point head, Vector direction) {
        this.head = head;
        // Normalizing the direction vector
        this.direction = direction.normalize();
    }


    public boolean equals(Object obj) {
        if (this == obj) return true;
        return (obj instanceof Ray r)
                && this.head.equals(r.head)
                && this.direction.equals(r.direction);
    }
    @Override
    public int hashCode() {
        return Objects.hash(head, direction);
    }


    public String toString() {
        return "Ray{" +
                "point=" + head+
                ", direction=" + direction +
                '}';


    }

    public Point getHead() {
        return head;
    }

    public Vector getDirection() {
        return direction;
    }

    /**
     * this method calculates the points on the ray which intersects the geometry
     * @param length
     * @return Point
     */
    public Point getPoint(double length) {
        return isZero(length ) ? head : head.add(direction.scale(length));
    }
}

