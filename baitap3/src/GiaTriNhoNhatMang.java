public class GiaTriNhoNhatMang {
    public static void main(String[] args) {
        int[] array = {1, 2, 7, 9, 5, 10, 19};
        int index = minValue(array);
        System.out.println("The smallest element in the array is: " + array[index]);
    }
    public static int minValue(int[] arr){
        int index = 0;
        for (int i = 1; i < arr.length; i++){
            if (arr[i] < arr[index]){
                index = i;
            }
        }
        return index;
    }
}
