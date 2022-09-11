import java.util.Scanner;

public class chuyentien {
    public static void main(String[] args) {
        double VND = 23000;
        double USD;
        Scanner sc = new Scanner(System.in);
        System.out.print("Số tiền USD cần đổi: ");
        USD = sc.nextDouble();
        double quydoi = USD * VND;
        System.out.println("Số tiền VND vừa đổi là: " + quydoi);
    }
}
