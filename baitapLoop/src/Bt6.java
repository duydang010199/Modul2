import java.util.Scanner;

public class Bt6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập n: ");
        int n = sc.nextInt();
        for (int i = 2; i <= n; i = i+ 2 ){
            System.out.println(i);
        }
    }
}
