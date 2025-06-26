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
        bowl.addFood(3);


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

class Animal {
    private static int totalAnimals = 0;
    private String name;

    public Animal(String name) {
        this.name = name;
        totalAnimals++;
    }

    public void run(int distance) {}

    public void swim(int distance) {}

    public String getName() {
        return name;
    }

    public static int getTotalAnimals() {
        return totalAnimals;
    }
}

class Dog extends Animal {
    private static int totalDogs = 0;
    private final int maxRunDistance = 500;
    private final int maxSwimDistance = 10;

    public Dog(String name) {
        super(name);
        totalDogs++;
    }

    @Override
    public void run(int distance) {
        if (distance <= maxRunDistance) {
            System.out.println(getName() + " пробежал " + distance + " м.");
        } else {
            System.out.println(getName() + " не может пробежать больше " + maxRunDistance + " м.");
        }
    }

    @Override
    public void swim(int distance) {
        if (distance <= maxSwimDistance) {
            System.out.println(getName() + " проплыл " + distance + " м.");
        } else {
            System.out.println(getName() + " не может проплыть больше " + maxSwimDistance + " м.");
        }
    }

    public static int getTotalDogs() {
        return totalDogs;
    }
}

class Cat extends Animal {
    private static int totalCats = 0;
    private final int maxRunDistance = 200;
    private boolean isFull;

    public Cat(String name) {
        super(name);
        this.isFull = false;
        totalCats++;
    }

    @Override
    public void run(int distance) {
        if (distance <= maxRunDistance) {
            System.out.println(getName() + " пробежал " + distance + " м.");
        } else {
            System.out.println(getName() + " не может пробежать больше " + maxRunDistance + " м.");
        }
    }

    @Override
    public void swim(int distance) {
        System.out.println(getName() + " не умеет плавать.");
    }

    public void eat(Bowl bowl) {
        if (bowl.getFoodAmount() >= 1 && !isFull) {
            bowl.setFoodAmount(bowl.getFoodAmount() - 1);
            isFull = true;
            System.out.println(getName() + " поел из миски.");
        } else if (isFull) {
            System.out.println(getName() + " уже сыт.");
        } else {
            System.out.println(getName() + " не смог поесть - в миске недостаточно еды.");
        }
    }

    public boolean isFull() {
        return isFull;
    }

    public static int getTotalCats() {
        return totalCats;
    }
}

class Bowl {
    private int foodAmount;

    public Bowl(int initialFood) {
        this.foodAmount = Math.max(0, initialFood);
    }

    public void addFood(int amount) {
        if (amount > 0) {
            foodAmount += amount;
            System.out.println("В миску добавлено " + amount + " еды. Теперь в миске " + foodAmount + " еды.");
        } else {
            System.out.println("Нельзя добавить отрицательное количество еды.");
        }
    }

    public int getFoodAmount() {
        return foodAmount;
    }

    public void setFoodAmount(int foodAmount) {
        this.foodAmount = foodAmount;
    }
}