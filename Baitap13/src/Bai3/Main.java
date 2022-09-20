package Bai3;

import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LinkedList<Character> max = new LinkedList<>();
        LinkedList<Character> list = new LinkedList<>();

        System.out.print("Nhập chuỗi: ");
        String str = sc.nextLine();

        for (int i = 0; i < str.length(); i++){
            if (list.size() > 1 && str.charAt(i) <= list.getLast() &&
            list.contains(str.charAt(i))) {
                list.clear();
            }
            list.add(str.charAt(i));

            if (list.size() > max.size()) {
                max.clear();
                max.addAll(list);
            }
        }
        for (Character ch: max){
            System.out.println(ch);
        }
        System.out.println();
    }
}
