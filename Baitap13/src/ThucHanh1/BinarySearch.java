package ThucHanh1;

public class BinarySearch {
        static int[] list = {2, 4, 5 ,10 ,12, 15, 17, 25, 31, 37, 40};

        static int binarySearch(int list[], int number){
            int low = 0;
            int high = list.length - 1;
            while (high >= low){
                int mid = (low + high) / 2;
                if (number < list[mid]){
                    high = mid - 1;
                } else if (number == list[mid]){
                    return mid;
                } else {
                    low = mid + 1;
                }
            } return -1;
        }

    public static void main(String[] args) {
        System.out.println(binarySearch(list, 2));
        System.out.println(binarySearch(list, 10));
        System.out.println(binarySearch(list, 39));
    }
}
