/**importing scanner.
*/
import java.util.Scanner;
/**defining class.
*/
final class Swap {
/** constructor declaration.
*/
    private Swap() {
}
/**defining method.
*/
    public static void main(final String[] args) {
/**main starts here.
*/
        Scanner s = new Scanner(System.in);
        int a = s.nextInt();
        int b = s.nextInt();
        int temp = a;
        a = b;
        b = temp;
        System.out.println("your input " + b + " " + a);
        System.out.println("swap output " + a + " " + b);
    }

}
