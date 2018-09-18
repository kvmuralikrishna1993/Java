class Catalog {
    private Item[] data;
    final int val = 50;
    private int itemcount;
    private Cart[] cartitems;
    private int cartcount;
    private double discount;
    Catalog () {
        data = new Item[val];
        itemcount = 0;
        cartitems = new Cart[val];
        cartcount = 0;
        discount = 0;
    }
    public void add(Item item) {
        data[itemcount] = item;
        itemcount++;                        
    }
    public void catalog() {
        for (int i =0; i < itemcount; i++) {
            System.out.println(data[i].item_name + " " +data[i].item_quantity + " " + (double)data[i].item_price);
        }
    }
    public void add( Cart ca) {
        boolean flag = true;
        for (int i = 0; i < cartcount; i++) {
            if (cartitems[i].item_name.equals(ca.item_name)) {
                cartitems[i].item_quantity = cartitems[i].item_quantity + ca.item_quantity;
                flag = false;
            }
        }
        if(flag) {
            cartitems[cartcount] = ca;
            cartcount++;
        }
    }
    public void show() {
        for (int i = 0; i < cartcount; i++) {
            System.out.println(cartitems[i].item_name + " " + cartitems[i].item_quantity);
        }
    }
    public double totalAmount() {
        double total = 0;
        for (int i = 0; i < cartcount; i++) {
            for (int j = 0; j < itemcount; j++) {
                if (cartitems[i].item_name.equals(data[j].item_name)) {
                total += data[j].item_price*cartitems[i].item_quantity;
                }
            }
        }
        return total;
    }
    public void coupon(String code) {
        if (this.discount == 0.0) {
            if (code.equals("IND10") || code.equals("IND20") || code.equals("IND30") || code.equals("IND50")) {
                this.discount = Integer.parseInt(code.substring(3, code.length()));
            } else {
                System.out.println("Invalid coupon");
            }
        }
    }

    public double payableAmount() {
        final double vat = 0.15;
        double ptotal = totalAmount();
        ptotal -= (ptotal*this.discount)/100;
        ptotal += ptotal*vat;
        return ptotal;
    }
    public void remove( Cart ca) {
        boolean flag = false;
        int position = 0;
        for (int i = 0; i < cartcount; i++) {
            if (cartitems[i].item_name.equals(ca.item_name)) {
                cartitems[i].item_quantity = cartitems[i].item_quantity - ca.item_quantity;
                if(cartitems[i].item_quantity == 0) {
                    position  = i;
                    flag = true;
                    break;
                }
            }
        }
        if (flag) {
            for (int i = position; i < cartcount; i++) {
                cartitems[i] = cartitems[i+1];
            }
            cartitems[cartcount -1] = null;
            cartcount--;
        }
    }
    public void print() {
        System.out.println("Name   quantity   Price");
        for (int i = 0; i < cartcount; i++) {
            for (int j = 0; j < itemcount; j++) {
                if (cartitems[i].item_name.equals(data[j].item_name)) {
                System.out.println(cartitems[i].item_name + " " +
                    cartitems[i].item_quantity + " " + (double)data[j].item_price);
                }
            }
        }
        //System.out.println("totalAmount: " + totalAmount());
        System.out.println("Total:"+totalAmount());
        System.out.println("Disc%:" + (totalAmount() * discount)/100);
        System.out.println("Tax:" + (totalAmount() - (totalAmount()*discount)/100)*0.15);
        System.out.println("Payable amount: " + payableAmount());
    }
}
class Item {
    String item_name;
    int item_quantity;
    int item_price;
    Item (String item_name, int item_quantity, int item_price) {
        this.item_name = item_name;
        this.item_quantity = item_quantity;
        this.item_price = item_price;
    }

}
class Cart {
    String item_name;
    int item_quantity;
    Cart( String item_name, int item_quantity) {
        this.item_name = item_name;
        this.item_quantity = item_quantity;
    }
}
