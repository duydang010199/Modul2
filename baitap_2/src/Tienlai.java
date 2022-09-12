import java.util.Scanner;

public class Tienlai {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double money = 1.0;
        int month = 1;
        double interest_rate = 1.0;
        System.out.println("Số tiền đầu tư: ");
        money = sc.nextDouble();
        if (money <= 0){
            System.out.println("Bạn nhập sai số tiền");
            return;
        }
        System.out.println("Số tháng: ");
        month = sc.nextInt();
        if (month < 1 || month > 12){
            System.out.println("Bạn nhập sai tháng");
            return;
        }
        System.out.println("Lãi suất hàng năm tính bằng phần trăm: ");
        interest_rate = sc.nextDouble();
        if (interest_rate < 0 || interest_rate > 100){
            System.out.println("Bạn nhập sai phần trăm lãi suất");
            return;
        }
        double total = 0;
        total = money * (interest_rate / 100) / 12 * month;
        System.out.println("Tổng lãi suất là: " + total);

    }
}

