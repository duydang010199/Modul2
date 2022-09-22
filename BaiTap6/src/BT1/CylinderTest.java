package BT1;

public class CylinderTest {
    public static void main(String[] args) {
        Cylinder cylinder = new Cylinder();
        System.out.println(cylinder);

        cylinder = new Cylinder(5,2,"Red");
        System.out.println(cylinder);
        System.out.println("Cylinder is " + cylinder.getVolume());
    }

}
