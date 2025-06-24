public class Product {
    String name;
    String production_date;
    String manufacturer;
    String country_of_origin;
    int price;
    boolean isBooked;


    public Product(String name, String production_date, String manufacturer,
                   String country_of_origin, int price, boolean isBooked) {
        this.name = name;
        this.production_date = production_date;
        this.manufacturer = manufacturer;
        this.country_of_origin = country_of_origin;
        this.price = price;
        this.isBooked = isBooked;
    }

    public void displayInfo() {
        System.out.println("Название: " + this.name);
        System.out.println("Дата производства: " + this.production_date);
        System.out.println("Производитель: " + this.manufacturer);
        System.out.println("Страна происхождения: " + this.country_of_origin);
        System.out.println("Цена: " + this.price + " руб.");
        System.out.println("Состояние бронирования: " + this.isBooked);
        System.out.println();
    }

    public static void main(String[] args) {

        Product product1 = new Product(
                "chocolate",
                "25.05.2025",
                "Milka",
                "Germany",
                5,
                true
        );

        product1.displayInfo();
    }
}