package bai1;

import java.util.Scanner;
import java.util.Stack;

public class DangChuoi {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Stack<String> stackChain = new Stack<>();

        System.out.print("Nhap chuoi: ");
        String str = sc.nextLine();
        for (int i = 0; i < str.length(); i++){
            stackChain.push(str.charAt(i) + "");
        }
        System.out.println("Chuoi dao nguoc: ");
        for (int i = 0; i < str.length(); i++){
            System.out.print(stackChain.pop() + " ");
        }

    }
}

