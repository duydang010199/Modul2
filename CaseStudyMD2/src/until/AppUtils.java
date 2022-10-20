package until;

import java.util.Scanner;

public class AppUtils {
    private static Scanner scanner = new Scanner(System.in);
    public static int retryParseInt(){
        int result;
        do {
            try {
                result = Integer.parseInt(scanner.nextLine());
                return result;
            } catch (Exception e){
                System.out.println("Nhập sai! Vui lòng nhập lại!");
                System.out.print(" ⭆ ");
            }
        } while (true);
    }
    public static double retryParseDoble(){
        double result;
        do {
            try {
                result = Double.parseDouble(scanner.nextLine());
                return result;
            } catch (Exception e){
                System.out.println("Nhập sai định dạng! Vui lòng nhập lại!");
                System.out.print(" ⭆ ");
            }
        } while (true);
    }
    public static long retryParseLong(){
        long result;
        do {
            try {
                result = Long.parseLong(scanner.nextLine());
                return result;
            } catch (Exception e){
                System.out.println("Nhập sai định dạng! Vui lòng nhập lại!");
                System.out.print(" ⭆ ");
            }
        } while (true);
    }
    public static void endProgram(){
        System.out.println("---------------------------- TẠM BIỆT VÀ HẸN GẶP LẠI! ----------------------------");
        System.exit(5);
    }
}
