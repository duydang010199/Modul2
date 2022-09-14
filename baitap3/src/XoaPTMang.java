import java.util.Arrays;
import java.util.Scanner;

public class XoaPTMang {
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
        System.out.println(Arrays.toString(array));
        System.out.print("Nhập giá trị cần xóa: ");
        int x = sc.nextInt();
//        int cnt=0;
//        for (int i = 0; i < array.length; i++) {
//            if (array[i]!=x){
//                array[cnt]=array[i];
//                cnt++;
//            }
//        }

//        int[] arr =new int[cnt];
//        for (int i = 0; i < arr.length; i++){
//            arr[i]=array[i];
//        }

        System.out.println(Arrays.toString(removeElement(array, x)));

    }
    public static int[] removeElement(int[] array, int x){
        int cnt=0;
        for (int i = 0; i < array.length; i++) {
            if (array[i]!=x){
                array[cnt]=array[i];
                cnt++;
            }
        }
        int[] arr =new int[cnt];
        for (int i = 0; i < arr.length; i++){
            arr[i]=array[i];
        }
        return arr;

    }
}
