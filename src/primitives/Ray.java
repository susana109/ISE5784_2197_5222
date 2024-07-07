package primitives;
import static primitives.Util.isZero;
import java.util.*;

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

    public Point findClosestPoint (List<Point> points){
        //The method first checks if the provided list points is null or empty and returns null if it's the case
            if (points == null || points.isEmpty()) {
                return null;
            }

            Point closestPoint = null;
            //minDistance is initialized to Double.MAX_VALUE, representing the largest possible value for a double.
            double minDistance = Double.MAX_VALUE;

            for (Point point : points) {
                //For each point, the method calculates the distance from the ray's head to this point
                // using the distance method of the Point class.
                double distance = head.distance(point);

                //The calculated distance is then compared with minDistance. If this distance is smaller than minDistance,
                // it means this point is the closest one found so far:
                if (distance < minDistance) {
                    //minDistance is updated to this new smaller distance.
                    minDistance = distance;
                    //closestPoint is updated to the current point.
                    closestPoint = point;
                }
            }

            return closestPoint;
        }

    }


