public class Park {

    public static class Attraction {
        private String name;
        private String workTime;
        private double price;


        public Attraction(String name, String workTime, double price) {
            this.name = name;
            this.workTime = workTime;
            this.price = price;
        }


        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getWorkTime() {
            return workTime;
        }

        public void setWorkTime(String workTime) {
            this.workTime = workTime;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }


        @Override
        public String toString() {
            return "Attraction: " + name +
                    ", Work Time: " + workTime +
                    ", Price: " + price + " USD";
        }
    }


    public static void main(String[] args) {

        Attraction attraction1 = new Attraction("Waltz", "10:00 - 20:00", 5.5);
        Attraction attraction2 = new Attraction("Ferris Wheel", "09:00 - 22:00", 8.0);

        
        System.out.println(attraction1);
        System.out.println(attraction2);
    }
}
