package course_moodle.lesson10;
import java.util.ArrayList;
import java.util.List;

// Базовый класс Fruit
class Fruit {
    private float weight;

    public Fruit(float weight) {
        this.weight = weight;
    }

    public float getWeight() {
        return weight;
    }
}

// Класс Apple, наследник Fruit
class Apple extends Fruit {
    public Apple() {
        super(1.0f); // Вес яблока 1.0
    }
}

// Класс Orange, наследник Fruit
class Orange extends Fruit {
    public Orange() {
        super(1.5f); // Вес апельсина 1.5
    }
}

// Класс Box для хранения фруктов
class Box<T extends Fruit> {
    private List<T> fruits = new ArrayList<>();

    // Метод для добавления фрукта в коробку
    public void addFruit(T fruit) {
        fruits.add(fruit);
    }

    // Метод для получения веса коробки
    public float getWeight() {
        float totalWeight = 0.0f;
        for (T fruit : fruits) {
            totalWeight += fruit.getWeight();
        }
        return totalWeight;
    }

    // Метод для сравнения веса текущей коробки с другой коробкой
    public boolean compare(Box<?> anotherBox) {
        return Math.abs(this.getWeight() - anotherBox.getWeight()) < 0.0001;
    }

    // Метод для пересыпания фруктов в другую коробку
    public void transferFruitsTo(Box<T> anotherBox) {
        if (this == anotherBox) {
            return; // Нельзя пересыпать фрукты в ту же коробку
        }
        if (anotherBox.fruits.isEmpty() || this.fruits.get(0).getClass() == anotherBox.fruits.get(0).getClass()) {
            anotherBox.fruits.addAll(this.fruits);
            this.fruits.clear();
        } else {
            throw new IllegalArgumentException("Нельзя пересыпать фрукты разных типов!");
        }
    }
}

// Пример использования
public class Main {
    public static void main(String[] args) {
        // Создаём коробки
        Box<Apple> appleBox = new Box<>();
        Box<Orange> orangeBox = new Box<>();
        Box<Apple> anotherAppleBox = new Box<>();

        // Добавляем фрукты в коробки
        appleBox.addFruit(new Apple());
        appleBox.addFruit(new Apple());
        orangeBox.addFruit(new Orange());
        orangeBox.addFruit(new Orange());
        orangeBox.addFruit(new Orange());

        // Выводим вес коробок
        System.out.println("Вес коробки с яблоками: " + appleBox.getWeight()); // 2.0
        System.out.println("Вес коробки с апельсинами: " + orangeBox.getWeight()); // 4.5

        // Сравниваем коробки
        System.out.println("Коробки равны по весу? " + appleBox.compare(orangeBox)); // false

        // Пересыпаем фрукты
        appleBox.transferFruitsTo(anotherAppleBox);
        System.out.println("Вес коробки с яблоками после пересыпания: " + appleBox.getWeight()); // 0.0
        System.out.println("Вес другой коробки с яблоками: " + anotherAppleBox.getWeight()); // 2.0
    }
}
