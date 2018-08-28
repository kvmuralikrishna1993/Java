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
        int radius = scan.nextInt();
        //int height = scan.nextInt();
        //double pii = pi();
        double area = areaOfCircle(radius);
        System.out.print("area of circle " + area);
     }
    /**.
     * { return pi.}
     *
     * @return    { description_of_the_return_value }
     */
    public static double pi() {
        final double pi = 3.14;
        return pi;
    }
    /**
    area function.
    @return None
    @param r integer
    @param pi integer
    */
    public static double areaOfCircle(final int r) {
        double pii = pi();
        double area = pii * r * r;
        return area;
    }
    /**
    Need to fill the areaOfTriangle function and print the output
    of fahrenheit.
    */
}
