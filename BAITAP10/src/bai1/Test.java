package bai1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class Test {
    public static void main(String[] args) {
        MyList<Integer> list = new MyList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(3);
        list.add(4);

        MyList<Integer> lClone = list.myClone();
        System.out.println(list);
        System.out.println(lClone);
        System.out.println(Arrays.toString(lClone.getElements()));
    }
}
