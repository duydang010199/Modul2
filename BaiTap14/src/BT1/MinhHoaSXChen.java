package BT1;

public class MinhHoaSXChen {
    public static void main(String[] args) {
        int[] array = {1, 7, 2, 5, 9, 4, 3, 6};
        inserSort(array);
    }
    public static void inserSort(int[] arr){
        int pos, x;
        for (int i = 1; i < arr.length; i++){
            x = arr[i];
            pos = i;
            while (pos > 0 && x < arr[pos - 1]){
                System.out.println("Swap " + arr[i] + " with "+ arr[i - 1]);
                arr[pos] = arr[pos - 1];
                pos--;
            }
            arr[pos] = x;
        }
        for (int j = 0; j < arr.length; j++) {
            System.out.print(arr[j] + "\t");
        }
        System.out.println();
    }
}
