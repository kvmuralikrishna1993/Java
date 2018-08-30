/**
importing scanner.
*/
import java.util.Scanner;
    /**
    class defining.
    */
final class Solution {
        /**
    constructor defining.
    */
    private Solution() {
    }
    /**
     * { function_description }.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        System.out.println("enter the no of numbers");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println("Enter the numbers");
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = sc.nextInt();
        }
        float result = average(array, n);
        System.out.println(result);
    }
    /**
    power function.
    @param a array
    @param len length
    @return int
    */
    public static float average(final int[] a, final int len) {
        int sum = 0;
        for (int i = 0; i < len; i++) {
            sum += a[i];
        }
        float average = sum/ len;
        return average;
    }
    /**
    Need to write the power function and print the output.
    */
}
