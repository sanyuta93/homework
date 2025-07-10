public class Main {

    public static void main(String[] args) {
        String[][] correctArray = {
                {"1", "2", "3", "4"},
                {"5", "6", "7", "8"},
                {"9", "10", "11", "12"},
                {"13", "14", "15", "16"}
        };

        String[][] wrongSizeArray = {
                {"1", "2", "3"},
                {"4", "5", "6"},
                {"7", "8", "9"}
        };

        String[][] wrongDataArray = {
                {"1", "2", "3", "4"},
                {"5", "6", "7", "8"},
                {"9", "10", "11", "12"},
                {"13", "14", "15", "abc"}
        };

        try {
            System.out.println("Сумма элементов правильного массива: " + sumArrayElements(correctArray));
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.out.println(e.getMessage());
        }

        try {
            System.out.println("Сумма элементов массива с неправильным размером: " + sumArrayElements(wrongSizeArray));
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.out.println(e.getMessage());
        }

        try {
            System.out.println("Сумма элементов массива с некорректными данными: " + sumArrayElements(wrongDataArray));
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.out.println(e.getMessage());
        }

        demonstrateArrayIndexOutOfBoundsException();
    }

    public static int sumArrayElements(String[][] array) throws MyArraySizeException, MyArrayDataException {

        if (array.length != 4) {
            throw new MyArraySizeException("Массив должен иметь размер 4x4, но количество строк: " + array.length);
        }

        for (int i = 0; i < array.length; i++) {
            if (array[i] == null || array[i].length != 4) {
                throw new MyArraySizeException(
                        String.format("Строка %d должна содержать 4 элемента, но содержит %d",
                                i, array[i] == null ? 0 : array[i].length)
                );
            }
        }

        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                try {
                    sum += Integer.parseInt(array[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException(
                            String.format("Некорректные данные в ячейке [%d][%d]: '%s'", i, j, array[i][j])
                    );
                }
            }
        }

        return sum;
    }

    public static void demonstrateArrayIndexOutOfBoundsException() {
        try {
            int[] arr = new int[5];
            int value = arr[10];
            System.out.println("Это сообщение не будет выведено");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Поймано ArrayIndexOutOfBoundsException: " + e.getMessage());
        }
    }
}



