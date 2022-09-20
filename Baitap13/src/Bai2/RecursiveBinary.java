package Bai2;


import java.util.Arrays;
import java.util.Scanner;

public class RecursiveBinary {
    public static void main(String[] args) {
        int[] array;
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập số phần tử của mảng: ");
        int size = sc.nextInt();
        array = new int[size];
        for (int i = 0; i < array.length; i++) {
            System.out.print("array[" + i + "]: ");
            array[i] = sc.nextInt();
        }
        System.out.println("array = " + Arrays.toString(array));
        sortASC(array);
        System.out.println("Mảng sắp xếp theo thứ tự từ bé đến lớn: ");
        show(array);
    }
    public static void sortASC(int[] arr) {
        int temp = arr[0];
        for (int i = 0 ; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    temp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = temp;
                }
            }
        }
    }
    public static void show(int [] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
    public int binarySearch(int[] array, int left, int right, int value){
        while (left > right){
            int middle = (left + right) / 2;
            if (array[middle] == value){
                return middle;
            } else if (value > array[middle]){
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }
        return -1;
    }
}
