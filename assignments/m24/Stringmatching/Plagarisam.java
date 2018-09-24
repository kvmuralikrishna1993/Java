import java.io.*;
import java.util.regex.*;
import java.util.*;
import java.lang.Math;
import java.lang.*;
/**
 * Class for plagarisam.
 */
class Plagarisam {
	private String[] fileArray;
	private String[] filenames;
	private int filecount;
	private final int val  = 10;
	private Map<Integer, String[]> dictionary;
	/**
	 * Constructs the object.
	 */
	Plagarisam() {
		dictionary = new HashMap<>();
		fileArray = new String[val];
		filenames = new String[val];
		filecount = 0;
	}
	/**
	 * { add files}.
	 *
	 * @param      args      The arguments
	 * @param      filename  The filename
	 */
	public void addfile(String args, String filename) {
		fileArray[filecount] = args;
		filenames[filecount] = filename;
		filecount++;
	}
	/**
	 * { cleans special characters}.
	 */
	public void cleanfile() {
		for (int i = 0; i < filecount; i++) {
			fileArray[i] = fileArray[i].replaceAll("[^-a-zA-Z0-9 \n\\(]", "");
			fileArray[i] = fileArray[i].replaceAll("[\n\\(]", " ");
			fileArray[i] = fileArray[i].trim().replaceAll(" +", " ");
			fileArray[i] = fileArray[i].toLowerCase();
		}
	}
	/**
	 * { function_frequency }.
	 */
	public double[][] distance() {
		for (int i = 0; i < filecount; i++) {
			String[] wordlist = fileArray[i].split(" ");
			dictionary.put(i, wordlist);
		}
		double length = 0;
		double[][] dis = new double[dictionary.size()][dictionary.size()]; 
		for(int i = 0; i < filecount; i++) {
			String s1 = fileArray[i];
			for(int j = 0; j < dictionary.size(); j++) {
				String[] temp = dictionary.get(j);
				String str = "";
				for(int k = 0; k < temp.length; k++) {
					str += temp[k];
					//System.out.println(str);
					if (s1.contains(str)){
						length = str.length();
					}
					str += " ";
					//System.out.println(str);
				}
				dis[i][j] = length;
			}
		}
		for(int i = 0; i < filecount; i++) {
			for(int j = 0; j < filecount; j++) {
				try {
					dis[i][j] = (dis[i][j]*2)/(fileArray[i].length()+fileArray[j].length())*100.0;
				} catch(ArithmeticException ae) {
					dis[i][j] = 0.0;
				}
			}
		}
		return dis;
	}
	public void printresult(){
		double[][] result = distance();
		String print = "";
		int file1 = 0;
		int file2 = 0;
		double max = result[0][1];
		System.out.println("            File1.txt	File2.txt	File3.txt	File4.txt	File5.txt");
		for(int i = 0; i < result.length; i++) {
			print = filenames[i] + "	";
			for(int j = 0; j < result.length; j++) {
				print += Math.round(result[i][j]) + "		";
				if (result[i][j] < 100) {
					if (max < result[i][j]) {
						max = result[i][j];
						file1 = i;
						file2 = j;
					}
				}
			}
			System.out.println(print);
		}
		System.out.println("Maximum similarity is between " + filenames[file1] + " and "+ filenames[file2]);
	}
}