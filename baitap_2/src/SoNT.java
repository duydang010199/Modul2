import java.util.Scanner;

public class SoNT {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Input number: ");
        int number = sc.nextInt();
        if (number < 2){
            System.out.println(number + " 1is NOT the prime.");
        } else {
            boolean check = true;
            for (int i = 2; i <= Math.sqrt(number) ;){
                if (number % i == 0){
                    check = false;
                    break;
                }
                i++;
            }
            if (check){
                System.out.println(number + " is a prime.");
            } else {
                System.out.println(number + " is NOT a prime.");
            }
        }

    }
}
