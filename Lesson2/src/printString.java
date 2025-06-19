public class printString {
    public static void printString (String text, int a) {

        for (int i = 0; i < a; i++) {
            System.out.println(text);
        }
    }

    public static void main(String[] args) {
        printString("Dog", 4);
        printString("Cat", 6);
    }
}
