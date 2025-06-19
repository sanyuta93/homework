
//Задание 7

public class checkNumber {
    public static boolean checkNumber (int a) {
        if (a<0) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        System.out.println(checkNumber(25));
        System.out.println(checkNumber(-25));
    }
}
