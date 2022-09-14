import java.util.Scanner;

public class TinhTongCot {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập số hàng: ");
        Integer[][] arr;
        int rows = sc.nextInt();
        System.out.print("Nhập số cột: ");
        int columns = sc.nextInt();
        arr = new Integer[rows][columns];
        for (int i = 0; i < rows; i++){
            for (int j = 0; j < columns; j++){
                System.out.print("array[" + i + "][" + j + "]: ");
                arr[i][j] = sc.nextInt();
            }
        }
        for (int i = 0; i < rows; i++){
            for (int j = 0; j < columns; j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println("");
        }
        //Tính tổng của cột cần tính
        System.out.print("Nhập cột muốn tính tổng: ");
        int colD = sc.nextInt();
        while (colD > rows - 1 || colD < 0){
            System.out.print("Nhập cột muốn tính tổng: ");
            colD = sc.nextInt();
        }
        float totalColumn = 0;
        for (int i = 0; i < rows; i++){
            totalColumn += arr[i][colD];
        }
        System.out.println("Tổng cột thứ " + colD + " là " + totalColumn);

        // Tính tổng đường chéo chính
        float totalDia = 0;
        if (columns == rows){
            for (int i = 0; i < rows; i++){
                totalDia += arr[i][i];
            }
            System.out.println("Tổng đường chéo chính của ma trận vuông " + rows + " x " + columns + " là: " + totalDia);
        } else {
            System.out.println("Ma trận không có đường chéo chính");
        }
    }
}
