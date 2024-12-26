package course.lesson3;

public class Park {
    public class Attraction {
        String name;
        String workingHours;
        int price;


        public Attraction(String name, String workingHours, int price) {
            this.name = name;
            this.workingHours = workingHours;
            this.price = price;
        }

        public void displayAttractionInfo() {
            System.out.println("Аттракцион: " + name + " Рабочие часы: " + workingHours + " Стоимость " + price);
        }
    }

    public static void main(String[] args) {

        Park park = new Park();


        Attraction attraction1 = park.new Attraction("Автодром", "10:00 - 20:00", 10);
        Attraction attraction2 = park.new Attraction("Центрифуга", "11:00 - 21:00", 15);

        attraction1.displayAttractionInfo();
        attraction2.displayAttractionInfo();
    }
}

