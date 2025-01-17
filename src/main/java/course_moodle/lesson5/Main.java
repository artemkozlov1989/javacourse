package course_moodle.lesson5;

// Класс Животное
abstract class Animal {
    private static int animalCount = 0;

    public Animal() {
        animalCount++;
    }

    public static int getAnimalCount() {
        return animalCount;
    }

    public abstract void run(int distance);
    public abstract void swim(int distance);
}

// Класс Собака
class Dog extends Animal {
    private static int dogCount = 0;

    public Dog() {
        dogCount++;
    }

    @Override
    public void run(int distance) {
        if (distance <= 500) {
            System.out.println("Собака пробежала " + distance + " м.");
        } else {
            System.out.println("Собака не может пробежать " + distance + " м.");
        }
    }

    @Override
    public void swim(int distance) {
        if (distance <= 10) {
            System.out.println("Собака проплыла " + distance + " м.");
        } else {
            System.out.println("Собака не может проплыть " + distance + " м.");
        }
    }

    public static int getDogCount() {
        return dogCount;
    }
}

// Класс Кот
class Cat extends Animal {
    private static int catCount = 0;
    private boolean isFull = false;

    public Cat() {
        catCount++;
    }

    @Override
    public void run(int distance) {
        if (distance <= 200) {
            System.out.println("Кот пробежал " + distance + " м.");
        } else {
            System.out.println("Кот не может пробежать " + distance + " м.");
        }
    }

    @Override
    public void swim(int distance) {
        System.out.println("Кот не умеет плавать.");
    }

    public boolean eat(int foodAmount, FoodBowl bowl) {
        if (foodAmount <= bowl.getFoodAmount() && !isFull) {
            bowl.decreaseFood(foodAmount);
            isFull = true;
            return true;
        }
        return false;
    }

    public boolean isFull() {
        return isFull;
    }

    public static int getCatCount() {
        return catCount;
    }
}

// Класс Тарелка с едой
class FoodBowl {
    private int foodAmount;

    public FoodBowl(int foodAmount) {
        this.foodAmount = foodAmount;
    }

    public int getFoodAmount() {
        return foodAmount;
    }

    public void decreaseFood(int amount) {
        if (amount <= foodAmount) {
            foodAmount -= amount;
        }
    }

    public void addFood(int amount) {
        if (amount > 0) {
            foodAmount += amount;
        }
    }
}

// Главный класс
public class Main {
    public static void main(String[] args) {
        Dog dog = new Dog();
        Cat[] cats = new Cat[3];
        for (int i = 0; i < cats.length; i++) {
            cats[i] = new Cat();
        }

        dog.run(150);
        dog.swim(5);

        FoodBowl bowl = new FoodBowl(20);

        for (Cat cat : cats) {
            if (cat.eat(10, bowl)) {
                System.out.println("Кот наелся.");
            } else {
                System.out.println("Коту не хватило еды.");
            }
        }

        System.out.println("Котов: " + Cat.getCatCount());
        System.out.println("Собак: " + Dog.getDogCount());
        System.out.println("Всех животных: " + Animal.getAnimalCount());
    }
}
