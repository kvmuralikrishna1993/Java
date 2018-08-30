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
        int m = scan.nextInt();
        int n = scan.nextInt();
        int[][] a = new int [m][n];

        for (int i = 0; i < m; i++) {
            scan.nextLine();
            for (int j = 0; j < n; j++ ) {
                a[i][j] = scan.nextInt();
            }
        }

        int p = scan.nextInt();
        int q = scan.nextInt();
        int[][] b = new int [p][q];

        for (int i = 0; i < p; i++) {
            scan.nextLine();
            for (int j = 0; j < q; j++ ) {
                b[i][j] = scan.nextInt();
            }
        }

        if (m == p && n == q) {
            matrixadd(a,b);
        } else {
            System.out.println("not possible");
        }

        /*for(int[] each: a){
            for (int val: each) {
                System.out.print(val);
            }
            System.out.println();
        }*/

    }
    /**
    area function.
    @return None
    @param a array
    @param b array
    */
    public static void matrixadd(int[][] a, int[][] b) {
        int[][] sum = new int [a.length][a[0].length];

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                sum[i][j] = a[i][j] + b[i][j];
            }
        }

        for(int[] each: sum) {
            for (int i = 0; i < each.length; i++) {
                System.out.print(each[i]);
                if (i < each.length-1) {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }

    }
    /**
    Need to fill the areaOfTriangle function and print the output
    of fahrenheit.
    */
}
