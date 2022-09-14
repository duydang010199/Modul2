import java.util.Scanner;

public class SoLanXuatHienCKT {
    public static void main(String[] args) {
        char ch;
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập chuỗi: ");
        String str = sc.nextLine();
        System.out.print("Nhập ký tự muốn kiểm tra: ");
        ch = sc.next().charAt(0);
        int count = 0;
        for (int i = 0; i < str.length(); i++){
            if (str.charAt(i) == ch){
               count++;
            }
        }
        System.out.println("Có " + count + " kí tự " + ch + " trong chuỗi.");

    }

}
