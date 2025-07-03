public class Product {
    private String name;
    private String productionDate;
    private String manufacturer;
    private String countryOfOrigin;
    private int price;
    private boolean isBooked;


    public Product(String name, String production_date, String manufacturer,
                   String country_of_origin, int price, boolean isBooked) {
        this.name = name;
        this.productionDate = production_date;
        this.manufacturer = manufacturer;
        this.countryOfOrigin = country_of_origin;
        this.price = price;
        this.isBooked = isBooked;
    }

    public void displayInfo() {
        System.out.println("Название: " + this.name);
        System.out.println("Дата производства: " + this.productionDate);
        System.out.println("Производитель: " + this.manufacturer);
        System.out.println("Страна происхождения: " + this.countryOfOrigin);
        System.out.println("Цена: " + this.price + " руб.");
        System.out.println("Состояние бронирования: " + this.isBooked);
        System.out.println();
    }
}