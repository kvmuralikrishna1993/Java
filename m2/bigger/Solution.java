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
        bigger(a, b);
    }
    /**
    bigger function.
    @param a integer
    @param b integer
    //@return None
    */
    public static void bigger(final int a, final int b) {
        /** program starts here.
        */
        if (a > b) {
            System.out.println(a + " is bigger");
        } else if (a < b) {
            System.out.println(b + " is bigger ");
        } else {
            System.out.println("they are equal");
        }
    }
    /**
    Need to fill the areaOfTriangle function and print the output
    of fahrenheit.
    */
}
