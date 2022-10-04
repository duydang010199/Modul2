package bai5;

import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.ConcurrentLinkedQueue;

public class Palindrome {
    public static void main(String[] args) {
        String array = "ere";
        Stack<Character> stack = new Stack<>();
        Queue<Character> queue = new ConcurrentLinkedQueue<>();
        for (int i = 0; i < array.length();i++){
            stack.push(array.charAt(i));
            queue.offer(array.charAt(i));
        }
        for (int i = 0; i < array.length();i++){
            if (stack.pop() != queue.remove()){
                System.out.println("Khong phai chuỗi palindrome!");
                return;
            }
        }
        System.out.println("La chuoi palindrome!");
    }
}
