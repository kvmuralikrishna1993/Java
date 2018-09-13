import java.io.BufferedInputStream;
import java.util.Scanner;
import java.util.Arrays;
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
class SetEmptyException extends Exception {
    /**
     * Constructs the object.
     *
     * @param      s     { parameter_description }
     */
    SetEmptyException(final String s) {
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
     * { function_add }.
     *
     * @param      item  The item
     */
    public void add(final int item) {
        boolean flag = false;
        int position = 0;
        if (size == 0) {
            set[size] = item;
        }
        if (!contains(item)) {
            if (size < set.length - 1) {
                for (int i = 0; i < size; i++) {
                    if (item < set[i]) {
                        flag = true;
                        position = i;
                        break;
                    }
                }
                if (flag) {
                    add(position, item);
                } else {
                    set[size] = item;
                    size += 1;
            }
            } else {
                set = resize(set);
                    for (int i = 0; i < size; i++) {
                        if (item < set[i]) {
                            flag = true;
                            position = i;
                            break;
                        }
                    }
                if (flag) {
                    add(position, item);
                } else {
                    set[size] = item;
                    size += 1;
                }
            }
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
                //System.out.println(i+" "+set[i]+" "+set[i-1]);
                //System.out.println(set[i-1]);
                set[i] = set[i - 1];
                //System.out.println(set[i]);
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
        String str = "{";
        String cmm = ", ";
        for (int i = 0; i < size; i++) {
            if (i == size - 1) {
                cmm = "";
            }
            str = str + Integer.toString(set[i]) + cmm;
        }
        str = str + '}';
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
     * { remove function }.
     *
     * @param      index  The index
     */
    public void remove(final int index) {
        if (index >= 0 && index < size) {
            for (int i = index; i < size - 1; i++) {
                set[i] = set[i + 1];
            }
            size -= 1;
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
     * { function_headset }.
     *
     * @param      item               The item
     *
     * @return     { description_of_the_return_value }
     *
     * @throws     SetEmptyException  { exception_description }
     */
    public Set headSet(final int item) throws SetEmptyException {
        Set hand = new Set();
        int min = 0;
        if (indexOf(item) == 0 || item < indexOf(set[0])) {
            throw new SetEmptyException("Set Empty Exception");
        } else if (contains(item)) {
            min = indexOf(item);
        } else {
            for (int i = 0; i < size; i++) {
                if (item >= set[i]) {
                    min = i + 1;
                }
            }
        }
        for (int i = 0; i < min; i++) { //addin to object.
                hand.add(set[i]);
        } return hand;
    }
    /**
     * { function_last }.
     *
     * @return     { description_of_the_return_value }
     *
     * @throws     SetEmptyException  { exception_description }
     */
    public int last() throws SetEmptyException {
        if (size == 0) {
            throw new SetEmptyException("Set Empty Exception");
        }
        return set[size - 1];
    }
    /**
     * { function_subset }.
     *
     * @param      item                      The item
     *
     * @return     { description_of_the_return_value }
     *
     * @throws     InvalidPositionException  { exception_description }
     */
    public Set subSet(final int[] item) throws InvalidPositionException {
        Set subset = new Set();
        boolean flag = false;
        if (item[0] > item[1]) {
            throw new InvalidPositionException(
                "Invalid Arguments to Subset Exception");
        }
        int min = 0; //intial position
        int max = 0;  // final position
        if (contains(item[0])) { //min check
            min = indexOf(item[0]);
        } else {
            for (int i = size - 1; i >= 0; i--) {
                if (item[0] <= set[i]) {
                    min = i;
                    flag = true;
                }
            }
        }
        if (contains(item[1])) { // max check
            max = indexOf(item[1]);
        } else {
            for (int i = 0; i < size; i++) {
                if (item[1] >= set[i]) {
                    max = i + 1;
                    flag = true;
                }
            }
        }
        for (int i = min; i < max; i++) { //adding values to object
            subset.add(set[i]);
        } return subset;
    }
    /**
     * { intersection function}.
     *
     * @param      args  The arguments
     *
     * @return     { description_of_the_return_value }
     */
    public Set intersection(final Set args) {
        Set inter = new Set();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < args.size(); j++) {
                if (set[i] == args.set[j]) {
                    inter.add(set[i]);
                }
            }
        } return inter;
    }
    /**
     * { function_retainAll }.
     *
     * @param      args  The arguments
     *
     * @return     { Object }
     */
    public Set retainAll(final Set args) {
        Set retain = new Set();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < args.size(); j++) {
                if (set[i] == args.set[j]) {
                    retain.add(set[i]);
                }
            }
        }
        return retain;
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
     * helper function to convert string input to int array.
     *
     * @param      s     { string input from test case file }
     *
     * @return     { int array from the given string }
     */
    public static int[] intArray(final String s) {
        String input = s;
        if (input.equals("[]")) {
            return new int[0];
        }
        if (s.contains("[")) {
            input = s.substring(1, s.length() - 1);
        }
        return Arrays.stream(input.split(","))
                            .mapToInt(Integer::parseInt)
                            .toArray();
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
                case "addAll":
                s.addAll(convert(tokens[1]));
                break;
                case "last":
                try {
                    System.out.println(s.last());
                } catch (SetEmptyException ex) {
                    System.out.println("Set Empty Exception");
                }
                break;
                case "headSet":
                try {
                    System.out.println(s.headSet(Integer.parseInt(tokens[1])));
                } catch (SetEmptyException ex) {
                    System.out.println("Set Empty Exception");
                }
                break;
                case "intersection":
                Set t = new Set();
                Set i = new Set();
                int[] intArray = intArray(tokens[1]);
                i.addAll(intArray);
                intArray = intArray(tokens[2]);
                t.addAll(intArray);
                System.out.println(i.intersection(t));
                break;
                case "retainAll":
                Set r = new Set();
                Set q = new Set();
                intArray = intArray(tokens[1]);
                q.addAll(intArray);
                intArray = intArray(tokens[2]);
                r.addAll(intArray);
                System.out.println(q.retainAll(r));
                break;
                case "subSet":
                int[] array = convert(tokens[1]);
                try {
                    System.out.println(s.subSet(convert(tokens[1])));
                } catch (InvalidPositionException ex) {
                    System.out.println("Invalid Arguments to Subset Exception");
                }
                break;
                default:
                break;
            }
        }
    }
}
