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


        for (int i = 0; i < row; i++){
            for (int j = 0; j < column; j++){
                System.out.print(array[i][j] + " ");
            }
            System.out.println("");
        }
        int max = array[0][0];
        int min = array[0][0];
        for (int i = 0; i < row; i++){
            for (int j = 0; j < column; j++){
                if (array[i][j] > max){
                    max = array[i][j];
                }
                if (array[i][j] < min){
                    min = array[i][j];
                }
            }
        }
        System.out.println("Giá trị lớn nhất là: " + max);
        System.out.println("Giá trị nhỏ nhất là: " + min);
    }
}
