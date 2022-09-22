package BT2;

import java.util.Arrays;

public class InsertionSort {
    public static void main(String[] args) {
        int[] array = {1, 3, 7, 4, 5, 9, 0, 2};
        InsertionSort.insertionSort(array);

    }
    public static void insertionSort(int[] arr){
        for (int i = 0; i < arr.length; i++){
            int tp = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > tp){
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = tp;
        }
        for (int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }
    }
}
