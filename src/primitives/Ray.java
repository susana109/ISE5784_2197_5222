package primitives;
import java.util.Objects;
import static primitives.Util.isZero;

/**
     * Ray class that represents a ray in a 3D Dimension
     */

public class Ray {
        /**
         * Point header of the Ray
         */


        private Point head;
        /**
         * Vector direction of the Ray
         */
        private Vector direction;

        /**
         * Constructor that gets a point and a vector and sets them
         * @param head point object represents the header of the Ray
         * @param direction vector object represents the vector of the Ray
         */

        public Ray(Point head, Vector direction){
            this.head = head;
            this.direction = direction.normalize();
        }




        /**
         * returns the point header of the ray
         * @return Point3D point header
         */
        public Point getHead() {
            return head;
        }

        /**
         * returns the vector direction of the ray
         * @return Vector vector direction
         */
        public Vector getDirection() {
            return direction;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            primitives.Ray ray = (primitives.Ray) o;
            return head.equals(ray.head) &&
                    direction.equals(ray.direction);
        }

        @Override
        public int hashCode() {
            return Objects.hash(head, direction);
        }

        @Override
        public String toString() {
            return "Ray [" +
                    "Point: " + head +
                    ", Direction " + direction +
                    "]";
        }

        /**
         * get target point
         * @param length length
         * @return Point3D Point3D
         */
        public Point getPoint(double length) {
            return isZero(length ) ? head : head.add(direction.scale(length));
        }
    }


