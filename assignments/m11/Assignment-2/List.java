import java.util.Arrays;
/*
     * The goal for the list is to store items.
     * How are we going to store the items in the list?
     * An array would be good. Right?
     * So, when we do not what we are going to have in the list
     * We need to create a Generic list to store the items

     * Here E is a type parameter, and it will be replaced with
        actual type when the object got created.
     */
public class List<E> {
    private E[] arr;
    private int sz;
    //Constructor
    public List() {
        // Create a variable of the type Object[]
        arr = ((E[])new Object[10]);//Object is the base class for all the classes
        sz = 0;
    }
    //Overloaded Constructor
    public List(int param) {
        arr = ((E[])new Object[param]);
        sz = 0;
    }
    /* The add method does what the name suggests.
     * Add a generic type item to the list.
     * The assumption is to store the item at the end of the list
     * What is the end of the list?
     * Is it the same as the end of the array?
     * Think about how you can use the size variable to add item
     * to the list.
     */
    /**
     * { Dynamic array }.
     *
     * @param      arr   The arr
     *
     * @return     { array }
     */
    private E[] resize(E[] arr) {
        E[] temp = ((E[])new Object[arr.length * 2]);
        System.arraycopy(arr, 0, temp, 0, sz);
        return temp;
    }
    /**
     * { add function }.
     *
     * @param      item  integers
     */
    public void add(final E item) {
        if (sz < arr.length) {
            arr[sz] = item;
            sz += 1;
        } else {
            arr = resize(arr);
            arr[sz] = item;
            sz += 1;
        }
    }
    /*Inserts all the elements of specified int
    array to the end of list*/
    /**
     * Adds all.
     *
     * @param      items  The items
     */
    public void addAll(E[] items) {
        //Write logic for addAll method
        for (int i = 0; i < items.length; i++) {
            add(items[i]);
        }
    }
    /**
     * { size function }.
     *
     * @return     { return size }
     */

    public int size() {
    	return sz;
    }
    /*
     * The remove method does what the name suggests.
     * Removes a String item, specified by the index argument, from the list
     * It also does an additional step.
     * Think about what happens when
     * an item is removed from the middle of the list
     * It creates a hole in the list, right?
     * This would mean, all the items that are
     * to the right side of the removed item should be
     * moved to the left by one position.
     * Here is an example:
     * array = [1,2,3,0,0,0,0,0,0,0]
     * remove(1) would remove the item 2 which is at index position 1.
     * But how do you remove the item from an array?
     * Well, the way to remove it is to move all
     * the items, that are to the right of the removed item, to the left
     * So, the new array looks like this.
     * array = [1,3,0,0,0,0,0,0,0,0]
     * The method returns void (nothing)
     */
    /**
     * { remove function }.
     *
     * @param      index  The index
     */
    public void remove(int index) {
        //Write logic for remove method
        if (index >= 0 && index < sz) {
            for (int i = index; i < sz - 1; i++) {
            arr[i] = arr[i + 1];
            }
            sz -= 1;
        } else {
            System.out.println("Invalid Position Exception");
        }
    }
    /*
     * Get method has to return the items that is
     * at the index position passed as an argument to the method.
     * If the item doesn't exist then return a -1 to indicate that
     * there is no element at that index.
     * How can an element not be there at a given position?
     * Well, if the position is greater than the number of items
     * in the list then that would mean the item doesn't exist.
     * How do we check if the position is greater than the
     * number of items in the list? Would size variable be useful?
     */

    public E get(int index) {
        if (index < sz && index > -1) {
            return arr[index];
        }
        return null;
    }
    /*
     * What happens when you print an object using println?
     * Java provides a method named toString that is internally
     * invoked when an object variable is used in println.
     * For example:
     * List l = new List();
     * System.out.println(l);
     * This statement is a shortcut for
     * System.out.println(l.toString());
     *
     * So, implement the toString method to display the items
     * in the list in the square brackets notation.
     * i.e., if the list has numbers 1, 2, 3
     * return the string [1,2,3]
     * Caution: The array may be having other elements
     * Example: [1,2,3,0,0,0,0,0,0,0]
     * toString should only return the items in the list and
     * not all the elements of the array.
     *
     */
    public String toString() {
        String str = "[";
        String cmm = ",";
        for (int i = 0; i < sz; i++) {
            if (i == sz - 1) {
                cmm = "";
            }
            str = str + arr[i] + cmm;
        }
        str = str + ']';
        return str;
    }
    /*
     * Contains return true if the list has
     * the item passed as an argument to the method
     * So, iterate through the list and return true if
     * the item exists and otherwise false
     */
    /**
     * { checks the element }.
     *
     * @param      item  The item
     *
     * @return     { true or false }
     */
    public boolean contains(E item) {
		//Write logic for contains method
         for (int i = 0; i < sz; i++) {
            if (arr[i].equals(item)) {
                return true;
            }
        }
        return false;
    }
    /*
     * Returns the index of the first occurrence
     * of the specified element in this list,
     * or -1 if this list does not contain the element.
     */
/**
 * Searches for the first match.
 *
 * @param      item  The item
 *
 * @return     { index }
 */
    public int indexOf(E item) {
       //Write logic for indexOf method
        for (int i = 0; i < sz; i++) {
            if (arr[i] == item) {
                return i;
            }
        }
        return -1;
    }

    /* Removes all of its elements that
     * are contained in the specified int array.
     */
    /**
     * Removes all.
     *
     * @param      items  The items
     */
    public void removeAll(E[] items)
    {
        //E[] copy = arr;
        for (int i = 0; i < items.length; i++) { 
            if (contains(items[i])) {
                for (int j = 0; j < sz; j++) {
                    if (items[i] == arr[j]) {
                    remove(j);
                    j--;
                    }
                }
            } 
        }
    }

    /*Returns a list containing elements, including
     startIndex and excluding endIndex. The first parameter
     indicates the startIndex and the second parameter
     indicates the endIndex.
     */
    /**
     * { sublist of n and n2 }.
     *
     * @param      n     { parameter_description }
     * @param      n2    The n 2
     *
     * @return     { description_of_the_return_value }
     */
    public List subList(int n, int n2) {
        List subarray = new List();
        if (n >= 0 && n2 <= sz) {
            for (int i = n; i < n2; i++) {
            subarray.add(arr[i]);
            }
            return subarray;

        }
        System.out.println("Index Out of Bounds Exception");
        return null;
    }
    /*Returns a boolean indicating whether the parameter
      i.e a List object is exactly matching with the given list or not.
     */

    public boolean equals(List<E> listdata)
    {
        if (toString().equals(listdata.toString())) {
            return true;
        }
        return false;
    }
    /*Removes all the elements from list*/
    public void clear() {
        for (int i = 0; i < sz; i++) {
            arr[i] = null;
        }
        sz = 0;
    }
}
