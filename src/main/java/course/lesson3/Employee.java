package course.lesson3;

public class Employee {
    String name;
    String position;
    String email;
    String phone;
    int salary;
    int age;


    public Employee(String name, String position, String email, String phone, int salary, int age) {
        this.name = name;
        this.position = position;
        this.email = email;
        this.phone = phone;
        this.salary = salary;
        this.age = age;
    }

    public void printInfo() {
        System.out.println("Имя: " + name + " Должность: " + position + " электронная почта: " + email + " телефон: " + phone + " зарплата:" + salary + " возраст: " + age);

    }

    public static void main(String[] args) {
        Employee employee1 = new Employee("Petrov Petr", "Manager", "petrov@mailbox.com", "892312313", 50000, 45);
        employee1.printInfo();

        //массив из 5 сотрудников
        Employee[] employeeArray = new Employee[5];

        employeeArray[0] = new Employee("Ivanov Ivan", "Engineer", "ivivan@mail.ru", "+789456778", 30000, 30);
        employeeArray[1] = new Employee("Petrov Ivan", "Manager", "petroPetr@mailbox.com", "4541228", 20000, 20);
        employeeArray[2] = new Employee("Sidorov Sid", "Technician", "sidorovSid@mailbox.com", "892312314", 28000, 50);
        employeeArray[3] = new Employee("Smirnova Anna", "Designer", "annaSmirnova@mailbox.com", "892312315", 60000, 35);
        employeeArray[4] = new Employee("Vasilev Vasiliy", "Developer", "vasiliyVasilev@mailbox.com", "892312316", 55000, 55);

        for (Employee employee : employeeArray) {
            if (employee.age > 40) {
                employee.printInfo();
            }
        }
    }
}

