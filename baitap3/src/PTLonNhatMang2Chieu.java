import java.util.Arrays;
import java.util.Scanner;

public class PTLonNhatMang2Chieu {
    public static void main(String[] args) {
        Integer[][] array;
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập số hàng: ");
        int row = sc.nextInt();
        System.out.print("Nhập số cột: ");
        int column = sc.nextInt();
        array = new Integer[row][column];
        for (int i = 0; i < row; i++){
            for (int j = 0; j < column; j++){
                System.out.print("array[" + i + "][" + j + "]: ");
                array[i][j] = sc.nextInt();
            }
        }

        // Hiển thì hàng và cột của mảng
        for (int i = 0; i < row; i++){
            for (int j = 0; j < column; j++){
                System.out.print(array[i][j] + " ");
            }
            System.out.println("");
        }
        System.out.println(Arrays.toString(maxMin(array, row, column)));
    }
    public static Integer[][] maxMin(Integer[][] arr,int row, int column){
        int max = arr[0][0];
        int min = arr[0][0];
        for (int i = 0; i < row; i++){
            for (int j = 0; j < column; j++){
                if (arr[i][j] > max){
                    max = arr[i][j];
                }
                if (arr[i][j] < min){
                    min = arr[i][j];
                }
            }

        }
        System.out.println("Giá trị lớn nhất là: " + max);
        System.out.println("Giá trị nhỏ nhất là: " + min);
        return arr;

    }
}
