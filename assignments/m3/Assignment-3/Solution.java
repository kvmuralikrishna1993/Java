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
        int result = gcd(a,b);
        System.out.print(result);
     }
    /**
     * { function_description. }
     *
     * @param      num   The number.
     *
     * @return     { count.  }
     */
    public static int gcd(final int a, final int b) {
    //Zero case

    if (a == 0 || b == 0){
       return 0;
    }
    // base case
    else if (a == b){
        return a;
    }
    // a is greater
    else if (a > b){
        return gcd(a-b, b);
    }
    else return gcd(a, b-a);
    }
    /**
    Need to fill the areaOfTriangle function and print the output
    of fahrenheit.
    */
}
