public class Main {
    public static void main(String[] args) {
        Dog dog1 = new Dog("Бобик");
        Dog dog2 = new Dog("Шарик");
        Cat cat1 = new Cat("Мурзик");
        Cat cat2 = new Cat("Барсик");
        Cat cat3 = new Cat("Васька");


        System.out.println("\nТестируем бег и плавание:");
        dog1.run(300);
        dog1.run(600);
        dog1.swim(5);
        dog1.swim(15);

        cat1.run(150);
        cat1.run(250);
        cat1.swim(10);

        Bowl bowl = new Bowl(2);
        bowl.addFood(3); // теперь в миске 5 еды

        Cat[] cats = {cat1, cat2, cat3};
        System.out.println("\nКормим котов:");
        for (Cat cat : cats) {
            cat.eat(bowl);
        }


        System.out.println("\nСостояние котов:");
        for (Cat cat : cats) {
            System.out.println(cat.getName() + ": " + (cat.isFull() ? "сыт" : "голоден"));
        }


        System.out.println("\nОбщее количество животных: " + Animal.getTotalAnimals());
        System.out.println("Количество собак: " + Dog.getTotalDogs());
        System.out.println("Количество котов: " + Cat.getTotalCats());
        System.out.println("Остаток еды в миске: " + bowl.getFoodAmount());
    }
}
