import java.util.Scanner;

public class Bt7 {
    public static void main(String[] args) {
        Scanner cs = new Scanner(System.in);
        System.out.println("Nhập N: ");
        int num = cs.nextInt();
        for (int j = 1; j <= num; j += 2){
            System.out.println(j);
        }
    }
}
