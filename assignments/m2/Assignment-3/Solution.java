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
    Do not modify this main function.
    @param args None
    */
    public static void main(final String[] args) {
        Scanner s = new Scanner(System.in);
        int base = s.nextInt();
        int exponent = s.nextInt();
        long result = power(base, exponent);
        System.out.println(result);
    }
    /**
    power function.
    @param b base
    @param e exponential
    @return Long
    */
    public static long power(final int b, final int e) {
        long mul = 1;
        int i;
        for (i = 1; i <= e; i++) {
            mul = mul * b;
        }
        return mul;
    }
    /**
    Need to write the power function and print the output.
    */
}
