
//задание 10

public class arrayInverter {
    public static void main(String[] args) {
        int[] array = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};

        System.out.println("Исходный массив:");
        printArray(array);

        invertArray(array);

        System.out.println("Инвертированный массив:");
        printArray(array);
    }


public static void invertArray(int[] arr) {
    for (int i = 0; i < arr.length; i++) {

        arr[i] = 1 - arr[i];
    }
}

public static void printArray(int[] arr) {
    for (int num : arr) {
        System.out.print(num + " ");
    }
    System.out.println();
}
}