package bai1;


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class DangSoNguyen {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<Integer>();
        list.add(4);
        list.add(1);
        list.add(3);
        list.add(6);
        list.add(2);
        System.out.println(list);
        Stack<Integer> stack = new Stack<Integer>();
        //Xóa từng phần tử của list sau đó thêm vào stack cho đến khi list rỗng
        while (list.size() > 0){
            stack.push(list.remove(0));
        }
        System.out.println(stack);
        while (stack.size() > 0){
            list.add(stack.pop());
        }
        System.out.println(list);
    }
}


