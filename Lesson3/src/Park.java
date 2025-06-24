import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



public class Park {
    private String parkName;
    private List<Attraction> attractions;


    public class Attraction {
        private String name;
        private Map<String, String> workingHours;
        private double price;

        public Attraction(String name, double price) {
            this.name = name;
            this.price = price;
            this.workingHours = new HashMap<>();
        }

        public void setWorkingHours(String day, String hours) {
            workingHours.put(day, hours);
        }

        public String getWorkingHours(String day) {
            return workingHours.getOrDefault(day, "Выходной");
        }

        public String getName() {
            return name;
        }

        public double getPrice() {
            return price;
        }

        @Override
        public String toString() {
            return String.format("%s - Цена: %.2f руб.", name, price);
        }
    }

    public Park(String parkName) {
        this.parkName = parkName;
        this.attractions = new ArrayList<>();
    }

    public void addAttraction(String name, double price) {
        Attraction newAttraction = new Attraction(name, price);
        attractions.add(newAttraction);
    }

    public Attraction getAttraction(String name) {
        for (Attraction attraction : attractions) {
            if (attraction.getName().equals(name)) {
                return attraction;
            }
        }
        return null;
    }

    public void printAllAttractions() {
        System.out.println("Аттракционы парка '" + parkName + "':");
        for (Attraction attraction : attractions) {
            System.out.println(attraction);
            System.out.println("  Режим работы:");
            System.out.println("  Пн: " + attraction.getWorkingHours("Monday"));
            System.out.println("  Вт: " + attraction.getWorkingHours("Tuesday"));
            System.out.println("  Ср: " + attraction.getWorkingHours("Wednesday"));
            System.out.println("  Чт: " + attraction.getWorkingHours("Thursday"));
            System.out.println("  Пт: " + attraction.getWorkingHours("Friday"));
            System.out.println("  Сб: " + attraction.getWorkingHours("Saturday"));
            System.out.println("  Вскр: " + attraction.getWorkingHours("Sunday"));
        }
    }

    public static void main(String[] args) {
        Park disneyland = new Park("Disneyland");


        disneyland.addAttraction("Space Mountain", 500);
        disneyland.addAttraction("Pirates of the Caribbean", 350);
        disneyland.addAttraction("Haunted Mansion", 400);


        Attraction spaceMountain = disneyland.getAttraction("Space Mountain");
        if (spaceMountain != null) {
            spaceMountain.setWorkingHours("Monday", "10:00-20:00");
            spaceMountain.setWorkingHours("Tuesday", "10:00-20:00");
            spaceMountain.setWorkingHours("Saturday", "9:00-22:00");
        }

        Attraction pirates = disneyland.getAttraction("Pirates of the Caribbean");
        if (pirates != null) {
            pirates.setWorkingHours("Monday", "11:00-19:00");
            pirates.setWorkingHours("Sunday", "10:00-21:00");
        }

        disneyland.printAllAttractions();
    }
}
