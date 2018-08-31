/**
    importing scanner.
    */
import java.util.Scanner;
/**
    class defined.
    */
final class Solution {
    /**
    Do not modify this main function.
    */
    private Solution() {
    /**
    constructor.
    */
    }
    /**
    main method.
    @param args None
    */
    public static void main(final String[] args) {
        /**
        main program starts here.
        */
        Scanner scan = new Scanner(System.in);
        int a = scan.nextInt();
        int b = scan.nextInt();
        int result = gcd(a, b);
        System.out.print(result);
     }
    /**
     * { gcd function. }
     *
     * @param      a     { first number}
     * @param      b     { second number.}
     *
     * @return     { integer. }
     */
    public static int gcd(final int a, final int b) {

    if (a == 0 || b == 0) {
       return 0;
    } else if (a == b) {
        return a;
    } else if (a > b) {
        return gcd(a - b, b);
    } else {
        return gcd(a, b - a);
      }
    }
}
