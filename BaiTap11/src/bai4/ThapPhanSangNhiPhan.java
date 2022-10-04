package bai4;


import java.util.Scanner;
import java.util.Stack;

public class ThapPhanSangNhiPhan {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack<Integer> stack = new Stack<>();
        System.out.print("Enter a positive integer from the keyboard: ");
        int x = sc.nextInt();
        while (x > 0){
            int surplus = x % 2;
            stack.push(surplus);
            x = x / 2;
        }
        System.out.println();
        System.out.print("Binary number is: ");
        for (int i = 0; i < stack.size(); i++){
            System.out.println(stack.pop());
        }
    }
}
