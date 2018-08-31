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
        int result = count(num);
        System.out.print(result);
     }
    /**
     * { count. }
     *
     * @param      num  The number.
     *
     * @return     { int (count.  }
     */
    public static int count(final int num) {
        char c = '7';
        int charcount = 0;
        for (int i = 1; i <= num; i++) {
            String check = Integer.toString(i);
            for (int j = 0; j < check.length(); j++) {
                char temp = check.charAt(j);
                if (temp == '7') {
                    charcount++;
                }
            }
        }
        return charcount;
    }
}
