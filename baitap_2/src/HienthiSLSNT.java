import java.util.Scanner;

public class HienthiSLSNT {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Số lượng số nguyên tố cần tìm là: ");
        int numbers = sc.nextInt();
        int countSNT = 0;
        int count = 0;
        for (int n = 2; n < 1000; n++){
            if (countSNT < numbers){
                for (int i = 1; i <= n; i++){
                    if (n % i == 0){
                        count += 1;
                    }
                }
                if (count == 2){
                    System.out.println(n);
                    countSNT += 1;
                }
                count = 0;
            } else {
                break;
            }
        }
    }
}

