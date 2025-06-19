
//задание 9


public class leapYear {
    public static boolean leapYear (int year) {
        if (year % 400 == 0) {
            return true;
        } if (year % 100 == 0) {
            return false;
        }
        return year % 4 == 0;
    }

    public static void main(String[] args) {
        System.out.println(leapYear(2024));
        System.out.println(leapYear(1990));
    }
}
