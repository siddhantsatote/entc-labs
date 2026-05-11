import java.util.Scanner;

public class QuadraticRoots {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a b c: ");
        double a = sc.nextDouble();
        double b = sc.nextDouble();
        double c = sc.nextDouble();

        double D = b*b - 4*a*c;

        if (D > 0) {
            double r1 = (-b + Math.sqrt(D)) / (2*a);
            double r2 = (-b - Math.sqrt(D)) / (2*a);
            System.out.println("Two distinct roots: x1=" + r1 + ", x2=" + r2);
        } else if (D == 0) {
            System.out.println("Repeated root: x=" + (-b / (2*a)));
        } else {
            double re = -b / (2*a);
            double im = Math.sqrt(-D) / (2*a);
            System.out.println("Complex: x1=" + re + "+" + im + "i, x2=" + re + "-" + im + "i");
        }

        sc.close();
    }
}
