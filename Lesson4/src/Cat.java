class Cat extends Animal {
    private static int totalCats = 0;
    private final int maxRunDistance = 200;
    private boolean isFull;

    public Cat(String name) {
        super(name);
        this.isFull = false; // кот изначально голоден
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