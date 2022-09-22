package BT2;

import java.util.Arrays;

public class Point2DTest {
    public static void main(String[] args) {
        Point2D point2D = new Point2D();
        System.out.println(point2D);

        point2D = new Point2D(3,7);
        System.out.println(point2D);
        System.out.println(Arrays.toString(point2D.setXY()));
    }
}
