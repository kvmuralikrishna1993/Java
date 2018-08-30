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
        String s = sc.nextLine();
        String reverse = reverseString(s);
        System.out.println(reverse);
    }
    /**
     * { function_description }.
     *
     * @param      str   The string
     *
     * @return     { description_of_the_return_value }
     */
    public static String reverseString(final String str) {
        String newstr = "";
        for (int j = str.length() - 1; j >= 0; j--) {
            newstr += Character.toString(str.charAt(j));
        }
        return newstr;
    }
    /**
    Need to fill the areaOfTriangle function and print the output
    of fahrenheit.
    */
}
