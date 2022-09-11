import java.util.Scanner;

public class Readnumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Số cần đọc: ");
        String number = sc.nextLine();
        //Số có 1 chữ số
        switch (number){
            case "1":
                System.out.print("one"); break;
            case "2":
                System.out.print("tow"); break;
            case "3":
                System.out.print("three"); break;
            case "4":
                System.out.print("four"); break;
            case "5":
                System.out.print("five"); break;
            case "6":
                System.out.print("six"); break;
            case "7":
                System.out.print("seven"); break;
            case "8":
                System.out.print("eight"); break;
            case "9":
                System.out.print("nice"); break;
            case "10":
                System.out.print("ten"); break;
            case "11":
                System.out.print("eleven"); break;
            case "12":
                System.out.print("twelve"); break;
        }
    }
}

