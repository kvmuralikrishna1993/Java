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
     * { function_description }
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = sc.nextInt();
        }
        int result = sort(array, n);
        System.out.println(result);
    }
    /**
    power function.
    @param a array
    @param len length
    @return int
    */
    public static int sort(final int[] a,final int len) {
        int max = a[0];
        for (int i = 1; i < len; i++) {
            if (max < a[i]){
                max = a[i];
            }
        }
        return max;
    }
    /**
    Need to write the power function and print the output.
    */
}
