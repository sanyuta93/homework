//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.println("Задание 1");

        Product product1 = new Product(
                "chocolate",
                "25.05.2025",
                "Milka",
                "Germany",
                5,
                true
        );

        product1.displayInfo();


        System.out.println("Задание 2");

        Product[] productsArray = new Product[5];

        productsArray[0] = new Product("Samsung S25 Ultra", "01.02.2025", "Samsung Corp.", "Korea", 5599, true);
        productsArray[1] = new Product("Samsung S24", "26.02.2025", "Samsung Corp.", "Korea", 6500, true);
        productsArray[2] = new Product("Samsung S23", "01.02.2024", "Samsung Corp.", "Korea", 3999, true);
        productsArray[3] = new Product("Samsung S25 ", "01.01.2025", "Samsung Corp.", "Korea", 6599, true);
        productsArray[4] = new Product("Samsung S25+ ", "01.02.2025", "Samsung Corp.", "Korea", 6999, false);


        System.out.println("Задание 3");

        Park.Attraction attraction1 = new Park.Attraction("Waltz", "10:00 - 20:00", 5.5);
        Park.Attraction attraction2 = new Park.Attraction("Ferris Wheel", "09:00 - 22:00", 8.0);


        System.out.println(attraction1);
        System.out.println(attraction2);

    }
}