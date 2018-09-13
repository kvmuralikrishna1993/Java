import java.io.BufferedInputStream;
import java.util.Scanner;
/**
 * Solution class for code-eval.
 */
public final class Solution extends Set {
    /**
     * Constructs the object.
     */
    private Solution() {

    }
    /**
     * { converting string to array }.
     *
     * @param      str   The string
     *
     * @return     { int array }
     */
    static int[] convert(final String str) {
        String[] tokens = str.split(",");
        int[] temp = new int[tokens.length];
        for (int i = 0; i < tokens.length; i++) {
            temp[i] = Integer.parseInt(tokens[i]);
        }
        return temp;
    }
    /**
     * main function to execute test cases.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        // instantiate this set
        Set s = new Set();
        // code to read the test cases input file
        Scanner stdin = new Scanner(new BufferedInputStream(System.in));
        // check if there is one more line to process
        while (stdin.hasNext()) {
            // read the line
            String line = stdin.nextLine();
            // split the line using space
            String[] tokens = line.split(" ");
            // based on the list operation invoke the corresponding method
            switch (tokens[0]) {
                case "size":
                System.out.println(s.size());
                break;
                case "contains":
                System.out.println(s.contains(Integer.parseInt(tokens[1])));
                break;
                case "print":
                System.out.println(s);
                break;
                case "add":
                s.add(Integer.parseInt(tokens[1]));
                break;
                case "addAll":
                s.addAll(convert(tokens[1]));
                break;
                case "last":
                System.out.println(s.last());
                break;
                case "headSet":
                System.out.println(s.headSet(Integer.parseInt(tokens[1])));
                break;
                case "subSet":
                int[] array = convert(tokens[1]);
                if (s.subSet(convert(tokens[1])) == null) {
                    System.out.println("Invalid Arguments to Subset Exception");
                } else {
                System.out.println(s.subSet(convert(tokens[1])));
                if (array[0] == array[1]) {
                    System.out.println("Set Empty Exception");
                }
                }
                break;
                default:
                break;
            }
        }
    }
}
