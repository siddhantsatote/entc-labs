class Employee {
    String name;
    double baseSalary;

    Employee(String n, double b) {
        name = n;
        baseSalary = b;
    }

    double computeSalary() {
        return baseSalary;
    }

    void display() {
        System.out.println(name + " -> Rs." + computeSalary());
    }
}

class Manager extends Employee {
    double bonus;

    Manager(String n, double b, double bonus) {
        super(n, b);
        this.bonus = bonus;
    }

    @Override
    double computeSalary() {
        return baseSalary + bonus;
    }
}

class Developer extends Employee {
    int overtime;
    double hourlyRate;

    Developer(String n, double b, int ot, double hr) {
        super(n, b);
        overtime = ot;
        hourlyRate = hr;
    }

    @Override
    double computeSalary() {
        return baseSalary + overtime * hourlyRate;
    }
}

public class InheritanceDemo {
    public static void main(String[] args) {
        new Employee("Alice", 30000).display();
        new Manager("Bob", 40000, 10000).display();
        new Developer("Charlie", 35000, 20, 500).display();
    }
}
