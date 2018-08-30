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
        boolean result = six(array, n);
        System.out.println(result);
    }
    /**
     * { function_description }
     *
     * @param      a     { parameter_description }
     * @param      len   The length
     *
     * @return     { description_of_the_return_value }
     */
    public static boolean six(final int[] a, final int len) {
        final int si = 6;
        if (a[0] == 6 || a[len-1] == 6){
        return true;   
        } else {
            return false;
        }
    }
    /**
    Need to write the power function and print the output.
    */
}
