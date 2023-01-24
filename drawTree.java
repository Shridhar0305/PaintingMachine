// Author name: Shridhar Vashishtha

import java.awt.Color;
public class DrawTree {
    /**
     * this function just make the image of the tree
     * @param args
     */
    public static void main(String[] args){
        ShapeDrawer drawShape = new ShapeDrawer(200, 200);
        Triangle t = new Triangle(new Point (100, 100), new Point(50, 200), new Point(150, 200));

        drawShape.setFill(Color.magenta);
        drawShape.setStroke(Color.magenta);
        drawShape.draw(t);
        drawShape.setFill(Color.orange);
        drawShape.setStroke(Color.orange);
        Circle c = new Circle(new Point(20, 20), 15);
        drawShape.draw(c);
        drawShape.setFill(Color.green);
        drawShape.setStroke(Color.green);
        Point[] arr = new Point[7];
        arr[0] = new Point(0, 100);
        arr[1] = new Point(200, 100);
        arr[2] = new Point(100, 50);
        arr[3] = new Point(50, 70);
        arr[4] = new Point(150, 70);
        arr[5] = new Point(100, 120);
        arr[6] = new Point(30, 50);
        drawShape.draw(ShapeUtils.makeFakePoly(arr));
        drawShape.setFill(Color.red);
        drawShape.setStroke(Color.red);
        Circle c2 = new Circle(new Point(170, 100), 10);
        drawShape.draw(c2);
        drawShape.writeToFile("tree.png");
        }
    }
