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
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        //System.out.println("Hi");
        sc.nextLine();
        for (int i = 0; i < n; i++) {
            String s = sc.nextLine();
            //System.out.println(s);
            String res = binaryToDecimal(s);//Write binaryToDecimal function
            System.out.println(res);
        }
     }
    /**
     * { function_description }.
     *
     * @param      binary  The binary
     *
     * @return     { description_of_the_return_value }
     */
    public static String binaryToDecimal(final String binary) {
       int power = 0;
       double sum = 0;
       final int base = 2;
       for (int j = binary.length() - 1; j >= 0; j--) {
                char temp = binary.charAt(j);
                int num = Character.getNumericValue(temp);
                //System.out.println(num);
                sum = sum + (num * Math.pow(base, power));
                //System.out.println(sum);
                power += 1;
        }
        //double result = sum;
        return (Long.toString(Math.round(sum)));
    }
    /**
    Need to fill the areaOfTriangle function and print the output
    of fahrenheit.
    */
}
