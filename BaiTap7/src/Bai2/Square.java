package Bai2;

public class Square extends Shape implements Colorable{
    private double width;

    public Square(String color, boolean filled, double width) {
        super(color, filled);
        this.width = width;
    }

    public Square(double width) {
        this.width = width;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getArea() {
        return this.width * width;
    }
    @Override
    public void howToColor() {
        System.out.println("Color all four sides");
    }

    @Override
    public String toString() {
        return "Square{" +
                "width=" + width +
                '}';
    }
}
