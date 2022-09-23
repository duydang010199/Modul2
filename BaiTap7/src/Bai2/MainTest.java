package Bai2;

public class MainTest {
    public static void main(String[] args) {
        Shape[] shape = new Shape[5];
        shape[0] = new Circle(3);
        shape[1] = new Square(5);
        shape[2] = new Rectangle(2,1);
        shape[3] = new Square(2);
        shape[4] = new Rectangle(3,4);
        for (Shape item: shape) {
            if (item instanceof Square){
                System.out.println(item);
                System.out.println("Dien tich " + ((Square) item).getArea());
                ((Square)item).howToColor();
                System.out.println();
            } else if (item instanceof Circle){
                System.out.println(item);
                System.out.println("Dien tich " + ((Circle)item).getArea());
                System.out.println();
            } else {
                System.out.println(item);
                System.out.println("Dien tich " + ((Rectangle)item).getArea());
                System.out.println();
            }
        }
    }
}
