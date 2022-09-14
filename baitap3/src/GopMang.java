import java.util.Arrays;
import java.util.Scanner;

public class GopMang {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Nhập phần tử vào mảng 1
        Integer[] arr1;
        System.out.print("Nhập số phần tử mảng 1: ");
        int size1 = sc.nextInt();
        arr1 = new Integer[size1];
        for (int i = 0; i < arr1.length; i++){
            System.out.print("arr1[" + i + "]: ");
            arr1[i] = sc.nextInt();
        }
        System.out.println("arr1 = " + Arrays.toString(arr1));

        // Nhập phần tử vào mảng 2
        Integer [] arr2;
        System.out.print("Nhập số phần tử mảng 2: ");
        int size2 = sc.nextInt();
        arr2 = new Integer[size2];
        for (int i = 0; i < arr2.length; i++){
            System.out.print("arr2[" + i + "]: ");
            arr2[i] = sc.nextInt();
        }
        System.out.println("arr2 = " + Arrays.toString(arr2));

        // Tạo mảng 3 = mảng 2 + mảng 1
        Integer[] arr3;
        arr3 = new Integer[size1 + size2];
        for (int i = 0; i < arr1.length; i++){
            arr3[i] = arr1[i];
        }
        for (int i = 0; i < arr2.length; i++){
            arr3[size1 + i] = arr2[i];
        }
        System.out.println("arr3 = " + Arrays.toString(arr3));

    }
}
