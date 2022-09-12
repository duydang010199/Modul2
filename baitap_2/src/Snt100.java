import java.util.Scanner;

public class Snt100 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập n:");
        int num = sc.nextInt();
        for (int x = 2; x <= num; x ++){
            if (isNgTo(x)){
                System.out.print(x + " ");
            }
        }
    }
    public static boolean isNgTo(int n){
        for (int i = 2; i <= Math.sqrt(n); i++){
            if (n % i == 0){
                return false;
            }
        }
        return true;
    }
}

