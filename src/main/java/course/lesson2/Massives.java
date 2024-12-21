package course.lesson2;

public class Massives {
    public static void main(String[] args) {
        int x = 10;
        int y = 20;
        boolean result = checkSum(x, y);
        System.out.println("Сумма чисел в пределах от 10 до 20 (включительно): " + result);

        checkNumber();

        int num = 10;
        boolean checkResult = isNegative(num);
        System.out.println(checkResult);

        String myString = "Hello, World!";
        int count = 3;
        printStringSeveralTimes(myString, count);

        int year = 2100;
        boolean leapYear = isLeapYear(year);
        System.out.println(year + " is a leap year: " + leapYear);

        int[] nums = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};    // массив №6

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                nums[i] = 1;
            } else {
                nums[i] = 0;
            }
        }
        for (int number : nums) {
            System.out.print(number + " ");
        }

        int[] massive = new int[100];                  //массив №7
        for(int i = 0; i < massive.length; i++) {
            massive[i] = i + 1;
        }
        for (int number : massive) {
            System.out.print(number + " ");
        }
        int[] anotherMassive = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};       //массив №8

        for (int i = 0; i < anotherMassive.length; i++) {
            if (anotherMassive[i] < 6) {
                anotherMassive[i] *= 2;
            }
        }
        for (int figures : anotherMassive) {
            System.out.print(figures + " ");
        }

        int n = 5;                                   //массив №9
        int[][] array = new int[n][n];


        for (int i = 0; i < n; i++) {
            array[i][i] = 1;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }

        int len = 5;
        int initialValue = 10;

        int[] resultArray = createArray(len, initialValue);


        for (int value : resultArray) {
            System.out.print(value + " ");
        }


    }
    public static boolean checkSum(int x, int y) {    //первый метод
        int sum = x + y;
        return sum >= 10 && sum <= 20;
    }
    public static void checkNumber(){                 //второй метод
        int a = 10;
        if (a >=0) {
            System.out.println("Введено положительное число");
        }
        else{
            System.out.println("Введено отрицательное число");
        }
    }
    public static boolean isNegative(int number){      //третий метод
        return number < 0;
        }
    public static void printStringSeveralTimes(String str, int count) {    //четвёртый метод
        for (int i = 0; i < count; i++) {
            System.out.println(str);
        }
    }
    public static boolean isLeapYear(int year) {               //пятый метод
        if (year % 4 == 0) {
            if (year % 100 == 0) {
                return year % 400 == 0;
            }
            return true;
        }
        return false;
    }
    public static int[] createArray(int len, int initialValue) {        //десятый метод
        int[] array = new int[len];

        for (int i = 0; i < len; i++) {
            array[i] = initialValue;
        }

        return array;
    }
    }
