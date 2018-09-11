import java.io.BufferedInputStream;
import java.util.Scanner;
/**
 * Exception for signaling invalid position errors.
 */
class InvalidPositionException extends Exception {
    /**
     * Constructs the object.
     *
     * @param      s     { parameter_description }
     */
    InvalidPositionException(final String s) {
        super(s);
    }
}
/**
 * Exception for signaling index outof bounds errors.
 */
class IndexOutofBoundsException extends Exception {
    /**
     * Constructs the object.
     *
     * @param      s     { parameter_description }
     */
    IndexOutofBoundsException(final String s) {
        super(s);
    }
}
/**
 * Class for set.
 * @author :
 */
class Set {
/**
 * { array declaration }.
 */
    private int[] set;
/**
 * { size declaration }.
 */
    private int size;
/**
 * { array size }.
 */
    private final int var = 10;
/**
 * Constructs the object.
 */
    Set() {
        set = new int[var];
        size = 0;
    }
    /**
     * { Dynamic array }.
     *
     * @param      args   The array
     *
     * @return     { array }
     */
    public int[] resize(final int[] args) {
        int[] temp = new int[(args.length * 2)];
        for (int i = 0; i < args.length; i++) {
            temp[i] = args[i];
        }
        return temp;
    }
    /**
     * { function_description }.
     *
     * @param      item  The item
     */
    public void add(final int item) {
            if (size < set.length) {
                set[size] = item;
                size += 1;
            } else {
                set = resize(set);
                    set[size] = item;
                    size += 1;
            }
    }
    /**
     * { returns size of list.}.
     *
     * @return     {size of list.}.
     */
    public int size() {
        // replace the code below to implement the size method
        return size;
    }
    /**
     * { addition index }.
     *
     * @param      index  The index
     * @param      item   The item
     */
    public void add(final int index, final int item) {
        if (index >= 0 && index < size) {
            for (int i = size; i > index; i--) {
                set[i] = set[i - 1];
            }
            set[index] = item;
            size++;
        }
    }
    /**
     * { checks the element in list.}.
     *
     * @param      item  The item
     *
     * @return     { true or false.}
     */
    public boolean contains(final int item) {
        for (int i = 0; i < size; i++) {
            if (set[i] == item) {
                return true;
            }
        }
        return false;
    }
        /**
     * {print display}.
     *
     * @return     String of list.
     */
    public String toString() {
        // Replace the code below
        String str = "[";
        String cmm = ",";
        for (int i = 0; i < size; i++) {
            if (i == size - 1) {
                cmm = "";
            }
            str = str + Integer.toString(set[i]) + cmm;
        }
        str = str + ']';
        return str;
    }
     /**
     * Adds all elements given.
     *
     * @param      item  The item
     */
    public void addAll(final int[] item) {
        for (int i = 0; i < item.length; i++) {
            add(item[i]);
        }
    }
    /**
     * { function_description }.
     *
     * @param      index                     The index
     *
     * @throws     InvalidPositionException  { exception_description }
     */
    public void remove(final int index) throws InvalidPositionException {
        if (index >= 0 && index < size) {
            for (int i = index; i < size; i++) {
                set[i] = set[i + 1];
            }
            size--;
        } else {
            throw new InvalidPositionException("Invalid Position Exception");
        }
    }
    /**
     * Searches for the first match.
     *
     * @param      item  element
     *
     * @return     { index.}
     */
    public int indexOf(final int item) {
        for (int i = 0; i < size; i++) {
            if (set[i] == item) {
                return i;
            }
        }
        return -1;
    }
    /**
     * { function_description }.
     *
     * @param      item  The item
     *
     * @return     { description_of_the_return_value }
     */
    public Set headSet(final int item) {
        Set hand = new Set();
        int min = 0;
        boolean flag = false;
        if (indexOf(item) == -1) {      // checking element index.
            for (int i = 0; i < size; i++) {
                if (item >= set[i]) {
                    min = i + 1;
                    flag = true;
                }
            }
        } else {
            min = indexOf(item);
        }
        for (int i = 0; i < min; i++) { //addin to object.
                hand.add(set[i]);
        } return hand;
    }
    /**
     * { function_ last }.
     *
     * @return     { last element }
     */
    public int last() {
        if (size == 0) {
            return -1;
        }
        return set[size - 1];
    }
    /**
     * { function_description }.
     *
     * @param      item                       The item
     * @return     { description_of_the_return_value }
     * @throws     IndexOutofBoundsException  {type}.
     */
    public Set subList(final int[] item) throws IndexOutofBoundsException {
        Set subset = new Set();
        int max = 0;
        int min = 0;
        if (item[0] > -1 && item[0] < size) {
            min = item[0];
        } else {
            throw new IndexOutofBoundsException(
                "Index Out of Bounds Exception");
        }
        if (item[1] == size) {
            max = size;
        } else if (item[1] > 0 && item[1] < size) {
            max = item[1];
        } else {
            return null;
        }
        for (int i = min; i < max; i++) { //adding values to object
            subset.add(set[i]);
        } return subset;
    }
    /**
     * { returns the index of list}.
     *
     * @param      index  The index.
     *
     * @return     { index.}
     */
    public int get(final int index) {
        if (index < size && index > -1) {
            return set[index];
        } else {
            return -1;
        }
    }
    /**
     * { count of element }.
     *
     * @param      item  element
     *
     * @return     { count of element}
     */
    public int count(final int item) {
        //Inserts the specified element at the end of the list.
        int cou = 0;
        for (int i = 0; i < size; i++) {
            if (set[i] == item) {
                cou++;
            }
        }
        return cou;
    }
    /**
     * Removes all.
     *
     * @param      args  The arguments
     */
    public void removeAll(final int[] args) {
        if (size > 0) {
            for (int i = 0; i < args.length; i++) {
                if (contains(args[i])) {
                    for (int j = 0;
                        j < count(args[i]); j++) {
                        try {
                            remove(indexOf(args[i]));
                        } catch (InvalidPositionException ex) {

                        }
                        j--;
                    }
                }
            }
        }
    }
    /**
     * { function clear}.
     */
    public void clear() {
        for (int i = 0; i < size; i++) {
            set[i] = 0;
        } size = 0;
    }
    /**
     * { checking list object}.
     *
     * @param      newlist  The newlist
     * @return     { description_of_the_return_value }
     */
    public boolean equals(final int[] newlist) {
        if (size == 0) {
            return false;
        }
        for (int i = 0; i < newlist.length; i++) {
            if (newlist[i] != set[i]) {
                return false;
            }
        }
        return true;
    }
}
/**
 * Solution class for code-eval.
 */
public final class Solution {
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
                case "remove":
                try {
                s.remove(Integer.parseInt(tokens[1]));
                } catch (InvalidPositionException ex) {
                    System.out.println(ex.getMessage());
                }
                break;
                case "removeAll":
                if (tokens.length > 1) {
                s.removeAll(convert(tokens[1]));
                }
                break;
                case "get":
                System.out.println(s.get(Integer.parseInt(tokens[1])));
                break;
                case "indexOf":
                System.out.println(s.indexOf(Integer.parseInt(tokens[1])));
                break;
                case "clear":
                s.clear();
                break;
                case "equals":
                if (tokens.length > 1) {
                System.out.println(s.equals(convert(tokens[1])));
                }
                break;
                case "count":
                System.out.println(s.count(Integer.parseInt(tokens[1])));
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
                case "subList":
                int[] array = convert(tokens[1]);
                try {
                    System.out.println(s.subList(convert(tokens[1])));
                } catch (IndexOutofBoundsException ex) {
                    System.out.println(ex.getMessage());
                }
                break;
                default:
                break;
            }
        }
    }
}
