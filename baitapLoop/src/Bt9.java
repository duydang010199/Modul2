import java.util.Scanner;

public class Bt9 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập số nguyên: ");
        String sn = sc.nextLine();
        // In theo chuỗi...
        StringBuilder str = new StringBuilder(sn);
        System.out.println("Số đảo ngược là: " + str.reverse().toString());

        // In theo số nguyên...
        //int sn = sn.nextInt();
//      int result = reverse_num(sn);
//      System.out.println("Số đảo ngược: " + result);
    }
//    private static int reverse_num(int sn){
//        int reverse = 0;
//        while (sn > 0) {
//            reverse = reverse * 10 + sn % 10;
//            sn = sn/10;
//        }
//        return reverse;
//    }
}
