package thuchanh3;

import java.util.Scanner;

public class CalculationExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Hãy nhập x: ");
        int x = scanner.nextInt();
        System.out.println("Hãy nhập y: ");
        int y = scanner.nextInt();
        CalculationExample calc = new CalculationExample();
        calc.calculate(x, y);
    }
    private void calculate(int x, int y){
        try{
            int a = x + y;
            int b = x - y;
            int c = x * y;
            int d = x / y;
            System.out.println("Tong la: " + a);
            System.out.println("Hieu la: " + b);
            System.out.println("Tich la: " + c);
            System.out.println("Thuong la: " + d);
        }
        catch (Exception e){
            System.out.println("Xay ra ngoai le: " + e.getMessage());
        }
    }
}
