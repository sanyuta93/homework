public class sumNumbers {
    public static boolean sumNumbers (int a, int b) {
        int sum = a + b;
        if (sum >= 10 && sum <= 20) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        System.out.println(sumNumbers(25, 10));
    }
}
