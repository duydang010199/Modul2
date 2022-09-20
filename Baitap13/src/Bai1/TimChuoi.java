package Bai1;

import java.util.LinkedList;
import java.util.Scanner;

public class TimChuoi {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập chuỗi: ");
        String ch = sc.nextLine();

        LinkedList<Character> max = new LinkedList<>();
        // LinkedList là 1 cấu trúc dữ liệu lưu trữ các phần tử dưới dạng danh sách
        // Các phần tử trong LinkedList được sắp xếp có thứ tự và có thể có giá trị giống nhau.
        for (int i = 0; i < ch.length(); i++){
            LinkedList<Character> list = new LinkedList<>();
            list.add(ch.charAt(i));
            for (int j = i + 1; j < ch.length(); j++){
                if (ch.charAt(j) > list.getLast()){
                    list.add(ch.charAt(j));
                }
            }
            if (list.size() > max.size()){
                max.clear();
                max.addAll(list);
            }
            list.clear();
        }
        for (Character cht: max){
            System.out.print(cht + " ");
        }
        System.out.println();
    }
    /*********************************************************************************
     * -	Tính toán độ phức tạp của bài toán:                                           *
     * -	1 vòng lặp bên ngoài = n;                                                     *
     * -	1 vòng lặp bên trong = n - 1;                                                 *
     * -    1 câu lệnh = 1                                                                *
     * -	1 vòng lặp * 1 câu lệnh = 1;                                                  *
     * -    T(n) = (n * (n - 1)) + (1 + 1);                                               *
     * -    T(n) = O(n^2) + O(n);                                                         *
     * -	T(n) = O(n^2);                                                                *
     * 	=> Độ phức tạp bài toán này là O(n^2)                                         *
     *********************************************************************************/
}
