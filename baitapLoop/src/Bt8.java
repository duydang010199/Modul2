import java.util.Scanner;

public class Bt8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập chuỗi: ");
        String st = sc.nextLine();
        int countChar = 1;
        int countString =1;
        String str = st.trim();
        for (int i = 0; i < str.length()-1; i++) {
            if (str.charAt(i) != ' ') {
                countChar += 1;
            }
            if (str.charAt(i) != ' ' && str.charAt(i+1) == ' ' ){
                countString+=1;
            }
        }
        System.out.println("số kí tự: " + countChar);
        System.out.println("số từ: " + countString);
    }
}
