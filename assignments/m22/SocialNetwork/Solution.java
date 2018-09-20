import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.TreeMap;
class Network {
	Map<String, String[]> dictionary;
	Network() {
		dictionary = new HashMap<>();
	}
	public void add(String args1, String args2) {
		String[] temparray = args2.split(", ");
			temparray[temparray.length - 1] =
			temparray[temparray.length - 1].substring(0, temparray[temparray.length - 1].length() - 1);
			dictionary.put(args1, temparray);
	}
	public boolean contains(String[] args, String check) {
		for (int i = 0; i < args.length; i++) {
			if (check.equals(args[i])) {
				return true;
			}
		} return false;
	}
	public void addConnections(String args1, String args2) {
		//System.out.println(args2);
		if (dictionary.containsKey(args1)) {
			if (dictionary.containsKey(args2)) {
				String[] temp = dictionary.get(args1);
				if (!contains(temp, args2)) {
					String[] temp2 = new String[temp.length + 1];
					for (int i = 0; i < temp.length; i++) {
						temp2[i] = temp[i];
						//System.out.println(temp[i]);
						//System.out.println(temp2[i]);
					}
					temp2[temp2.length-1] = args2;
					dictionary.put(args1, temp2);
				}
			} else {
				System.out.println("Not a user in Network");
			}
		} else {
			System.out.println("Not a user in Network");
		}
	}
	public void getConnections(String args) {
		if (dictionary.containsKey(args)) {
			String temp = "[";
			String[] temp2 = dictionary.get(args);
			for (int i = 0; i < temp2.length; i++) {
				temp += temp2[i] + ", ";
				if (i == temp2.length - 1) {
					temp = temp.substring(0, temp.length() - 2);
					temp = temp + "]";
				}
			}
			System.out.println(temp); 
		} else {
			System.out.println("Not a user in Network");	
		}
	}
	public void commonConnections(String args1, String args2) {
		boolean flag = false;
		if (dictionary.containsKey(args1)) {
			if (dictionary.containsKey(args2)) {
				String str = "[";
				String[] temp1 = dictionary.get(args1);
				String[] temp2 = dictionary.get(args2);
				for (int i = 0; i < temp1.length; i++) {
					if(contains(temp2, temp1[i])) {
						str += temp1[i] + ", ";
						flag = true;
					}
				} if (flag) {
					str = str.substring(0, str.length() - 2);
				}
				str += "]";
				System.out.println(str);
			}
		}
	}
	public void network() {
		TreeMap<String, String[]> sorted_dictionary = new TreeMap<>();
		sorted_dictionary.putAll(dictionary); 
		Iterator<String> itr = sorted_dictionary.keySet().iterator();
		String temp = "";
		while(itr.hasNext()) {
			String str = itr.next();
			String[] temp2 = sorted_dictionary.get(str);
			temp += str + ": [";
			for (int i = 0; i < temp2.length; i++) {
				temp += temp2[i] + ", ";
			}
			temp = temp.substring(0, temp.length() - 2); 
			temp = temp + "], ";
		}
		System.out.println(temp.substring(0, temp.length()-2));
	}
}
public class Solution {
	Solution() {

	}
	public static void main(String[] args) {
		Network n = new Network();
		Scanner s = new Scanner(System.in);
		String value = s.nextLine();
		String[] temp = value.split(" ");
		for(int i = 0; i < Integer.parseInt(temp[1]); i++) {
			//read
			String line = s.nextLine();
			String[] temp2 = line.split(" is connected to ");
			n.add(temp2[0], temp2[1]);
		}
		while (s.hasNext()) {
			String function = s.nextLine();
             // split the line using space
            String[] tokens = function.split(" ");
            switch (tokens[0]) {
            	case "addConnections":
            	n.addConnections(tokens[1], tokens[2]);
                break;
                case "getConnections":
                n.getConnections(tokens[1]);
                break;
                case "CommonConnections":
                //System.out.println(tokens[1]);
                //System.out.println(tokens[2]);
                n.commonConnections(tokens[1], tokens[2]);
                break;
                case "Network":
                n.network();
                break;
                default:
                break;
            }

		}
	}
}