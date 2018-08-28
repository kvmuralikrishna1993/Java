/**
importing scanner.
*/
import java.util.Scanner;
/**
importing scanner.
*/
final class Solution {
    /**
    constructor.
    */
    private Solution() {

    }
    /**
    Do not modify this main function.
    @param args None
    */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        int a = scan.nextInt();
        int b = scan.nextInt();
        int c = scan.nextInt();
        rootsQE(a, b, c);
    }
    /**
    root function.
    @param a int
    @param b int
    @param c int
    */
    public static void rootsQE(final int a, final int b, final int c) {
        final int i = 4;
        final int j = 2;
        float determinant = (b * b) - (i * a * c);
        //if (determinant > 0){
            double root1 = (-b + Math.sqrt(determinant)) / (j * a);
            double root2 = (-b - Math.sqrt(determinant)) / (j * a);
            System.out.println(root1 + " " + root2);
            //System.out.print(" ");
            //System.out.print(root2);
        //}
        //else if (determinant < 0){
        //  System.out.println("No roots");
        //}
        //else{
        //  float root = -b / 2 * a;
        //  System.out.println(root + " " + root);

        //}
    /*
    Need to write the rootsOfQuadraticEquation
    function and print the output.
    */
}
}
