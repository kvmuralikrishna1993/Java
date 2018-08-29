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
        int num = scan.nextInt();
        //int height = scan.nextInt();
        //double pii = pi();
        int result = sumN(num);
        System.out.print(result+"  ");
     }
    /**
    area function.
    @return integer
    @param num integer
    //@param pi integer
    */
    public static int sumN(final int num) {
        int s = (num*(num + 1))/2;
        return s;
    }
    /**
    Need to fill the areaOfTriangle function and print the output
    of fahrenheit.
    */
}
