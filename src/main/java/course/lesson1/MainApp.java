package course.lesson1;

public class MainApp {
    public static void printThreeWords() {
        System.out.println("Orange");
        System.out.println("Banana");
        System.out.println("Apple");
    }
    public static void main(String[] args) {
        checkSumSign();
        printColor();
        compareNumbers();
    }
    public static void checkSumSign() {
        int a = 1;
        int b = 2;
        if ((a + b) >= 0) {
            System.out.println("Сумма положительная");
        } else {
            System.out.println("Сумма отрицательная");
        }
    }
    public static void printColor() {
        int value = 30;
        if (value <= 0) {
            System.out.println("Красный");
        } else if (value > 0 && value <= 100) {
            System.out.println("Желтый");
        } else {
            System.out.println("Зелёный");
        }
    }
    public static void compareNumbers() {
        int a = 44;
        int b = 45;
        if(a>=b){
            System.out.println("a >= b");
        }
        else{
            System.out.println("a < b");
        }
    }
}
