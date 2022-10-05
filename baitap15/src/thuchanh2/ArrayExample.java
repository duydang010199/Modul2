package thuchanh2;

import java.util.Random;
import java.util.Scanner;

public class ArrayExample {
    public Integer[] createdRandom(){
        Random rd = new Random();
        Integer[] arr = new Integer[100];
        System.out.println("Danh sach phan tu cua mang: ");
        for (int i = 0; i < 100; i++){
            arr[i] = rd.nextInt(100);
            System.out.println(arr[i] + " ");
        }
        return arr;
    }

    public static void main(String[] args) {
        ArrayExample arrayExample = new ArrayExample();
        Integer[] array = arrayExample.createdRandom();
        Scanner sc = new Scanner(System.in);
        System.out.println("\nVui long nhap phan tu cua 1 phan tu bat ky: ");
        int x = sc.nextInt();
        try {
            System.out.println("Gia tri cua phan tu co chi so 5 " + x + " la " + array[x]);
        }
        catch (IndexOutOfBoundsException e){
            System.out.println("Chi so vuot qua gioi han cua mang");
        }
    }
}
