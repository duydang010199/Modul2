package BT1;

public class Cylinder extends Circlee{
    private double height = 3.0;
    public Cylinder(){}
    public Cylinder(double height, double radius, String color){
        super(radius, color);
        this.height = height;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }
    public double getVolume(){
        return getRadius() * getRadius() * Math.PI * this.height;
    }

    @Override
    public String toString() {
        return "A Cylinder with height = "
                + getHeight()
                + ", which is a subclass of "
                + super.toString();
    }
}
