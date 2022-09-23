package BT7.Bai1;

import ThucHanh.Circle;
import ThucHanh.Shape;

public class TestFull {
    public static void main(String[] args) {
        Shape[] shape = new Shape[5];
        shape[0] = new BT7.Bai1.Circle(3);
        shape[1] = new BT7.Bai1.Circle(0.5);
        shape[2] = new BT7.Bai1.Rectangle(5, 4);
        shape[3] = new BT7.Bai1.Circle(4);
        shape[4] = new BT7.Bai1.Rectangle(3,5);
        for (Shape item : shape){
            if (item instanceof BT7.Bai1.Circle){
                System.out.println(item);
                double percent = Math.random() * 100 + 1;
                System.out.println(percent);
                ((BT7.Bai1.Circle)item).resize(percent);
                System.out.println(item);
            } else {
                System.out.println(item);
                double percent = Math.random() * 100 + 1;
                System.out.println(percent);
                ((BT7.Bai1.Rectangle)item).resize(percent);
                System.out.println(item);
            }
        }
    }
}
