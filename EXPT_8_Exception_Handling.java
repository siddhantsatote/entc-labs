import java.util.Scanner;

// Part i) - built-in exceptions
class ExceptionDemo {
    static void demo() {
        try {
            int[] arr = {10, 20, 30};
            System.out.println(arr[5]);  // ArrayIndexOutOfBoundsException
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Caught: " + e.getMessage());
        } finally {
            System.out.println("Finally block always runs.");
        }
    }
}

// Part ii) - user-defined exception
class InvalidAgeException extends Exception {
    InvalidAgeException(String msg) {
        super(msg);
    }
}

class VoterCheck {
    static void validate(int age) throws InvalidAgeException {
        if (age < 18) {
            throw new InvalidAgeException("Age " + age + " < 18. Not eligible!");
        }
        System.out.println("Age " + age + ": Eligible to vote.");
    }
}

public class ExceptionMain {
    public static void main(String[] args) {
        ExceptionDemo.demo();

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter age: ");

        try {
            VoterCheck.validate(sc.nextInt());
        } catch (InvalidAgeException e) {
            System.out.println("Error: " + e.getMessage());
        }

        sc.close();
    }
}
