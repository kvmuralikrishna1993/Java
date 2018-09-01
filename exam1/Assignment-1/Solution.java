import java.util.Scanner;
/**
 * Write a java program to find the odd composite numbers
 * between 2 and n where n is given as an input.
 *
 * @author :
 */
public final class Solution {
    /**
    * Empty constructor.
    */
    private Solution() {
        //not used
    }
    /**
     * Prints the odd composite numbers between 2 and n.
     *
     * @param      n     n value
     */
    static void oddComposites(final int n) {
        int count = 0;
                for (int i = 2; i <= n; i++) {
            if (n % i == 0) {
                count += 1;
            }
            int flag = 0;
            if (count > 2) {
                for (int j = 2; j < i / 2; j++) {
                    if (i % j == 0) {
                        flag = 1;
                    }
                }
                if (flag == 1) {
                    if (i % 2 == 1) {
                        System.out.println(i);
                    }
                }
            }
        }
    }

    /**
    * main method as driver program.
    * @param args is the parameter for this method
    */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        oddComposites(n);
    }
}

