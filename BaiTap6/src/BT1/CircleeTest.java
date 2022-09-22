package BT1;

public class CircleeTest {
    public static void main(String[] args) {
        Circlee circlee = new Circlee();
        System.out.println(circlee);

        circlee = new Circlee(3,"Orange");
        System.out.println(circlee);
        System.out.println("Area is " + circlee.getArea());
    }
}
