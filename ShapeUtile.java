// Author Name: Shridhar Vashishtha

import java.lang.Math;
public class ShapeUtils {
    /**
     * gives the distance between two points using the distance formula.
     * @param p1 is the first point
     * @param p2 is the second point
     * @return is the double value which is the distance between the points.
     */
    public static double distance(Point p1, Point p2){
        double distance;
        double x1 = p1.getX();
        double x2 = p2.getX();
        double y1 = p1.getY();
        double y2 = p2.getY();
        distance = Math.sqrt(Math.pow((x1 - x2), 2) + Math.pow((y1 - y2), 2));

        return distance;
    }

    /**
     * gets the center (average) of an array of Points
     * @param points is the array of points
     * @return is the Point which is the center of all the points from the array of points.
     */
    public static Point getCenter(Point[] points){
        if (points.length == 0){
            return new Point (0, 0);
        }
        else{
            double avgX = 0;
            double avgY = 0;
            for(int i = 0; i < points.length; i++){
               avgX += points[i].getX();
               avgY += points[i].getY();
            }
            return new Point((avgX / points.length), (avgY / points.length) );
        }
    }

    /**
     * makes arrays of triangles to make more complex polygon
     * @param points which is the array of points
     * @return is the arrays of triangles
     */
    public static Triangle [] makeFakePoly(Point[] points){
        Triangle [] ans = new Triangle[points.length];
        Point center = getCenter(points);   // how to do this?
        for(int i = 0; i < points.length - 1; i++){
            ans[i] = new Triangle(points[i], points[i+1], center);
        }
        ans[ans.length - 1] = new Triangle(points[points.length - 1], points[0], center);

        return ans;
    }

    /**
     * gives the area of a circle by using the formula PI * r * r
     * @param c is the circle whose area is to be found
     * @return is the area
     */
    public static double getArea(Circle c){
        double area;
        double radius = c.getRadius();
        area = Math.PI * radius * radius;

        return area;
    }

    /**
     * gives the area of a triangle
     * @param t is the triangle whose area is to be found
     * @return is the area of the triangle.
     */
    public static double getArea(Triangle t){
        double x1 = t.getP1().getX();
        double y1 = t.getP1().getY();
        double x2 = t.getP2().getX();
        double y2 = t.getP2().getY();
        double x3 = t.getP3().getX();
        double y3 = t.getP3().getY();

        double area = (Math.abs((x1 * (y2 - y3)) + (x2 * (y3 - y1)) + (x3 * (y1 - y2)))) * 0.5;
        return area;
    }

    /**
     * checks if the point is in the triangle
     * @param t is the triangle
     * @param p is the point
     * @return true if the point is in the triangle, otherwisw false
     */
    public static boolean isIn(Triangle t, Point p){
        double areaOriginal = getArea(t);
        Triangle t1 = new Triangle(p, t.getP2(), t.getP3());
        Triangle t2 = new Triangle(t.getP1(), p, t.getP3());
        Triangle t3 = new Triangle(t.getP1(), t.getP2(), p);

        double areaSub = getArea(t1) + getArea(t2) + getArea(t3);


       if (Math.abs(areaOriginal - areaSub) < 0.00001){

           return true;
       }
       else{

         return false;
       }
    }

    /**
     * checks if the point is in the circle
     * @param c is the circle
     * @param p is the point
     * @return true if the point is in the circle, otherwise, false
     */
    public static boolean isIn(Circle c, Point p){
        double radius = c.getRadius();
        Point cent = c.getCenter();
        double dist = distance(cent, p);

        if (dist <= radius){
            return true;
        }
        else{
            return false;
        }
    }

    /**
     * checks if two circles overlaps or not
     * @param c1 is the first circle
     * @param c2 is the second circle
     * @return true if the circles overlap, otherwise, false
     */
    public static boolean isThereOverlap(Circle c1, Circle c2){
        double r1 = c1.getRadius();
        double r2 = c2.getRadius();
        Point cent1 = c1.getCenter();
        Point cent2 = c2.getCenter();

        double dist = distance(cent1, cent2);
        double r = r1 + r2;

        if(dist < r){
            return true;
        }
        else{
            return false;
        }
    }
}
