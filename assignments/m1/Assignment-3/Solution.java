/**
importing scanner.
    */
import java.util.Scanner;
/**
    class defining.
    */
final class Solution {
    /**
    constructor.
    */
    private Solution() {

    }
    /**
    Do not modify this main function.
    */
    /**
        main function.
        @param args None
    */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        double degreesCelsius = scan.nextDouble();
        calculateFromDtoF(degreesCelsius);
    }
    /**
        convertion function.
        @param degreesCelsius None
    */
    public static void calculateFromDtoF(final double degreesCelsius) {
        final int a = 9;
        final int b = 5;
        final int c = 32;
        double fahrenheit = (a * degreesCelsius / b) + c;
        System.out.println(fahrenheit);
    }
    /**
    Need to fill the calculateFromDegreesToFarenheit function
    and print the output
    of fahrenheit.
    */
}
