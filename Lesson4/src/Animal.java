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

