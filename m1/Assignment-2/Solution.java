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
        int base = scan.nextInt();
        int height = scan.nextInt();
        float area = areaOfTriangle(base, height);
        System.out.print(area);
    }
    /**
    area function.
    @return None
    @param b integer
    @param h integer
    */
    public static float areaOfTriangle(final int b, final int h) {
        float area = b * h / 2;
        return area;

    }
    /**
    Need to fill the areaOfTriangle function and print the output
    of fahrenheit.
    */
}
