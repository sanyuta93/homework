public class whatNumber {
    public static void whatNumber (int a) {
       if (a >= 0) {
            System.out.println("Число положительное");
        } else {
            System.out.println("Число отрицательное");
        }
    }

    public static void main(String[] args) {
        whatNumber(-10);
        whatNumber(10);
    }
}
