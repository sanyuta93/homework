
//Задание 13

    public class DiagonalArray {
        public static void main(String[] args) {
            int size = 5;
            int[][] matrix = new int[size][size];

            for (int i = 0; i < size; i++) {
                matrix[i][i] = 1;
                matrix[i][size - 1 - i] = 1;
            }

            printMatrix(matrix);
        }

        public static void printMatrix(int[][] matrix) {
            for (int[] row : matrix) {
                for (int num : row) {
                    System.out.print(num + " ");
                }
                System.out.println();
            }
        }
    }


