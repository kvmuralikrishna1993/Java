import java.util.Scanner;
/**
 * { class Solution }.
 */
public final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {

    }
    /**
     * { function_main }.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Catalog c = new Catalog();
        Scanner scan = new Scanner(System.in);
        int testcases = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < testcases; i++) {
            String tokens = scan.nextLine();
            String[] check = tokens.split(" ");
            switch (check[0]) {
                case "Item":
                String[] items = check[1].split(",");
                c.add(new Item(items[0],
                    Integer.parseInt(items[1]), Integer.parseInt(items[2])));
                break;
                case "catalog":
                c.catalog();
                break;
                case "add":
                String[] cartitem = check[1].split(",");
                c.add(new Cart(cartitem[0], Integer.parseInt(cartitem[1])));
                break;
                case "show":
                c.show();
                break;
                case "totalAmount":
                System.out.println("totalAmount: " + c.totalAmount());
                break;
                case "remove":
                String[] removeitem = check[1].split(",");
                c.remove(new Cart(removeitem[0],
                    Integer.parseInt(removeitem[1])));
                break;
                case "payableAmount":
                System.out.println("Payable amount: " + c.payableAmount());
                break;
                case "print":
                c.print();
                break;
                case "coupon":
                c.coupon(check[1]);
                break;
                default:
                break;
            }
        }
    }
}
