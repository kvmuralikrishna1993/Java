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
        pattern(num);
        //System.out.print(result+"  ");
     }
    /**
    area function.
    @return integer
    @param num integer
    //@param pi integer
    */
    public static void pattern(final int num) {
        for (int i=1;i<=num;i++){
            for (int j=1;j<=i;j++){
            System.out.print(j);
            System.out.print(" ");
            }
            System.out.println("");
        }

        
    }
    /**
    Need to fill the areaOfTriangle function and print the output
    of fahrenheit.
    */
}
