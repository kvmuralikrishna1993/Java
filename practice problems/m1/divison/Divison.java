/**importing scanner.
*/
import java.util.Scanner;
/**defining class.
*/
final class Divison {
/** constructor declaration.
*/
    private Divison() {
}
/**defining method.
@param args None
*/
    public static void main(final String[] args) {
/**main starts here.
*/
        Scanner s = new Scanner(System.in);
        int a = s.nextInt();
        int b = s.nextInt();
        final int remainder = a % b;
        final int quotient = a / b;
        System.out.println("remainder " + remainder + "  quotient " + quotient);
    }

}
