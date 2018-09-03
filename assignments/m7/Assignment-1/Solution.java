/**
 * { Importing scanner }.
 */
import java.util.Scanner;
/**
 * Class for input validator.
 */
class InputValidator {
/**
 * { string }.
 */
    private String str;
/**
 * Constructs the object.
 *
 * @param      st    { passing string }
 */
    InputValidator(final String st) {
        str = st;
    }
    /**
     * { validate data }.
     *
     * @return     { boolean }
     */
    public boolean validateData() {
        //String varr = str;
        //System.out.println(str.length());
        final int condition = 6;
        return (str.length() >= condition);
    }
}
/**
 * Class for solution.
 */
final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {
    }
    /**
     * { function_description }.
     *
     * @param      args  The arguments.b
     */
    public static void main(final String[] args) {
        Scanner s = new Scanner(System.in);
        String input = s.next();
        InputValidator i = new InputValidator(input);
        System.out.println(i.validateData());
    }

}
