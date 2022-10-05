package bai1;

import java.util.Scanner;

public class TriangleException {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TriangleException triangle = new TriangleException();
        try {
            System.out.print("Nhap canh A: ");
            int a = sc.nextInt();
            System.out.print("Nhap canh B: ");
            int b = sc.nextInt();
            System.out.print("Nhap canh C: ");
            int c = sc.nextInt();
            try{
                triangle.calculate(a, b, c);
            }
            catch (TriangleEdges edges){
                System.out.println(edges.getMessage());
            }
        }
        catch (Exception e) {
            System.out.println("Loi ngoai le");
        }
    }
    public void calculate(int a, int b, int c) throws TriangleEdges  {
        if (a + b <= c || a + c <= b || b + c <= a) {
            throw new TriangleEdges ("Tam giac khong hop le");
        } else {
            System.out.println("Canh A: " + a + ", canh B: " + b + ", canh C: " + c + " la canh cua tam giac");
        }
    }
}
