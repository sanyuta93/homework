
//Задание 11


    public class fillArray {
        public static void main(String[] args) {
            int[] numbers = new int[100];

            for (int i = 0; i < numbers.length; i++) {
                numbers[i] = i + 1;
            }

            System.out.println("Заполненный массив:");
            for (int num : numbers) {
                System.out.print(num + " ");
            }
        }
    }

