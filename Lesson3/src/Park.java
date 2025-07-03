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
}
