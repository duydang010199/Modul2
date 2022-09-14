import java.util.Arrays;
import java.util.Scanner;

public class ThemPTMang {
    public static void main(String[] args) {
        Integer[] array;
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập số phần tử của mảng: ");
        int size = sc.nextInt();
        array = new Integer[size];
        for (int i = 0; i < array.length-1; i++){
            System.out.print("array[" + i + "]: ");
            array[i] = sc.nextInt();
        }
        System.out.println("array = " + Arrays.toString(array));
        System.out.println("Nhập phần tử muốn thêm: ");
        int x = sc.nextInt();
        System.out.println("Nhập vị trí muốn chèn: ");
        int index = sc.nextInt();
        while (index < 0 || index > array.length - 1){
            System.out.println("Không thể chèn vào vị trí bạn vừa nhập!");
            System.out.println("Mời bạn nhập lại");
            index = sc.nextInt();
        }

        for (int i = array.length - 2; i >= index; i--){
            array[i + 1] = array[i];
        }
        array[index] = x;
        System.out.println(Arrays.toString(array));
    }
}
