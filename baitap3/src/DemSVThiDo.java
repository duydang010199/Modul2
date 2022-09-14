import java.util.Scanner;

public class DemSVThiDo {
    public static void main(String[] args) {
        int size;
        int [] array;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.print("Enter a size: ");
            size = sc.nextInt();
            if (size > 30){
                System.out.println("Size should not exceed 30");
            }
        } while (size > 30);
        // Nhập giá trị phần tử mảng
        array = new int[size];
        int i = 0;
        while (i < array.length){
            System.out.print("Enter a mark for student " + (i + 1) + ": ");
            array[i] = sc.nextInt();
            i++;
        }
        // in ra ds điểm và đếm số lượng SV thi đỗ
        int count = 0;
        System.out.print("List of mark: ");
        for (int j = 0; j < array.length; j++){
            System.out.print(array[j] + "\t");
            if (array[j] >= 5 && array[j] <= 10){
                count++;
            }
        }
        System.out.print("\n The number of students passing the exam is " + count);
    }
}
