
//Задание 14

public class arrayCreator {
    public static void main(String[] args) {

        int[] array1 = createArray(5, 10);
        int[] array2 = createArray(3, -1);

        printArray(array1);
        printArray(array2);
    }

    public static int[] createArray(int len, int initialValue) {
        int[] array = new int[len];
        for (int i = 0; i < len; i++) {
            array[i] = initialValue;
        }
        return array;
    }


    public static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
