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
	public void distance() {
		for (int i = 0; i < filecount; i++) {
			String[] wordlist = fileArray[i].split(" ");
			dictionary.put(i, wordlist);
		}
		int length = 0;
		long[][] dis = new long[dictionary.size()][dictionary.size()]; 
		for(int i = 0; i < filecount; i++) {
			String s1 = fileArray[i];
			for(int j = 0; j < dictionary.size(); j++) {
				String[] temp = dictionary.get(j);
				String str = "";
				for(int k = 0; k < temp.length; k++) {
					str += temp[k];
					if (s1.contains(str)){
						length = str.length();
					}
					str += " ";
				}
				dis[i][j] = length;
			}
		}
		for(int i = 0; i < filecount; i++) {
			for(int j = 0; j < filecount; j++){
				System.out.println(dis[i][i]+" "+fileArray[i].length()+" "+fileArray[j].length());
				//dis[i][j] = (dis[i][j]/(fileArray[i].length()*fileArray[j].length()))*100.0;
				System.out.print(dis[i][j]/(fileArray[i].length()*fileArray[j].length())*100.0+" ");
			}System.out.println();
		}
	}
	/**
	 * { function_print}.
	public void printresult(){
		long[][] result = distance();
		String print = "";
		int file1 = 0;
		int file2 = 0;
		long max = result[0][1];
		System.out.println("            File1.txt	File2.txt	File3.txt	File4.txt	File5.txt");
		for(int i = 0; i < result.length; i++) {
			print = filenames[i] + "	";
			for(int j = 0; j < result.length; j++) {
				print += result[i][j] + "		";
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
	}*/
}