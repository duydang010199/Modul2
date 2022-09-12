import java.util.Scanner;

public class Readnumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Input number: ");
        int number = sc.nextInt();
        while (number < 0 || number > 999) {
            System.out.println("Out of ability");
            number = sc.nextInt();
        }
        String hangTram = "";
        String hangChuc = "";
        String hangDonvi = "";
        int hTr = number / 100;
        int hCh = (number % 100) / 10;
        int hDV = (number % 100) % 10;
        switch (hTr){
            case 0: hangTram = ""; break;
            case 1: hangTram = "one hundred"; break;
            case 2: hangTram = "tow hundred"; break;
            case 3: hangTram = "three hundred"; break;
            case 4: hangTram = "four hundred"; break;
            case 5: hangTram = "five hundred"; break;
            case 6: hangTram = "six hundred"; break;
            case 7: hangTram = "seven hundred"; break;
            case 8: hangTram = "eight hundred"; break;
            case 9: hangTram = "nine hundred"; break;
        }
        switch (hCh){
            case 1:
                switch (number % 100){
                    case 10: hangChuc = "ten"; break;
                    case 11: hangChuc = "eleven"; break;
                    case 12: hangChuc = "twelve"; break;
                    case 13: hangChuc = "thirteen"; break;
                    case 14: hangChuc = "fourteen"; break;
                    case 15: hangChuc = "fifteen"; break;
                    case 16: hangChuc = "sixteen"; break;
                    case 17: hangChuc = "seventeen"; break;
                    case 18: hangChuc = "eighteen"; break;
                    case 19: hangChuc = "nineteen"; break;
                }
            break;
            case 2: hangChuc = "twenty"; break;
            case 3: hangChuc = "thirty"; break;
            case 4: hangChuc = "forty"; break;
            case 5: hangChuc = "fifty"; break;
            case 6: hangChuc = "sixty"; break;
            case 7: hangChuc = "seventy"; break;
            case 8: hangChuc = "eighty"; break;
            case 9: hangChuc = "ninety"; break;
        }
        switch (hDV){
            case 1: hangDonvi = "one"; break;
            case 2: hangDonvi = "two"; break;
            case 3: hangDonvi = "three"; break;
            case 4: hangDonvi = "four"; break;
            case 5: hangDonvi = "five"; break;
            case 6: hangDonvi = "six"; break;
            case 7: hangDonvi = "seven"; break;
            case 8: hangDonvi = "eight"; break;
            case 9: hangDonvi = "nice"; break;
        }
        if (number == 0){
            System.out.println("zero");
        }
        if ((number % 100) / 10 == 1){
            System.out.println(hangTram + " " + hangChuc);
        } else {
            System.out.println(hangTram + " " + hangChuc + " " + hangDonvi);
        }
    }
}

