public class productsArray {



    public static void main(String[] args) {
        Product[] productsArray = new Product[5];

        productsArray[0] = new Product("Samsung S25 Ultra", "01.02.2025", "Samsung Corp.", "Korea", 5599, true);
        productsArray[1] = new Product("Samsung S24", "26.02.2025", "Samsung Corp.", "Korea", 6500, true);
        productsArray[2] = new Product("Samsung S23", "01.02.2024", "Samsung Corp.", "Korea", 3999, true);
        productsArray[3] = new Product("Samsung S25 ", "01.01.2025", "Samsung Corp.", "Korea", 6599, true);
        productsArray[4] = new Product("Samsung S25+ ", "01.02.2025", "Samsung Corp.", "Korea", 6999, false);
    }

}
