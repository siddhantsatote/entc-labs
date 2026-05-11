import java.util.Arrays;

public class SortDemo {

    static void sortIntegers() {
        int[] nums = {45, 12, 78, 23, 56, 3, 99};
        System.out.println("Before: " + Arrays.toString(nums));
        Arrays.sort(nums);
        System.out.println("After : " + Arrays.toString(nums));
    }

    static void sortNames() {
        String[] names = {"Raj", "Ananya", "Priya", "Kiran", "Deepak"};
        System.out.println("Before: " + Arrays.toString(names));
        Arrays.sort(names);
        System.out.println("After : " + Arrays.toString(names));
    }

    public static void main(String[] args) {
        sortIntegers();
        System.out.println();
        sortNames();
    }
}
