import java.io.*;
import java.util.regex.*;
import java.util.*;
import java.lang.Math;
/**
 * Class for plagarisam.
 */
class Plagarisam {
	private String[] fileArray;
	private String[] filenames;
	private int filecount;
	private final int val  = 10;
	private List<Map<String, Integer>> hashdic;
	/**
	 * Constructs the object.
	 */
	Plagarisam() {
		hashdic = new ArrayList<Map<String,Integer>>();
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
			fileArray[i] = fileArray[i].replaceAll("[^-a-zA-Z0-9 ]", "");
			//fileArray[i] = fileArray[i].replaceAll("[\n\\(]", " ");
			//fileArray[i] = fileArray[i].trim().replaceAll(" +", " ");
			fileArray[i] = fileArray[i].toLowerCase().trim();
		}
	}
	/**
	 * { function_frequency }.
	 */
	public void frequency() {
		int k = 0;
		for (int i = 0; i < filecount; i++) {
			String[] wordlist = fileArray[i].split(" ");
			Map<String, Integer> dictionary = new HashMap<>();
			for (String word : wordlist) {
				Integer count = dictionary.get(word);
				count = (count == null) ? 1 : ++count;
				if (count == null ){
					dictionary.put(word, 0);
				} else {
					dictionary.put(word, count);
				}
			}
			hashdic.add(k,dictionary);
			k++;
		}
	}
	/**
	 * { function_dotproduct }
	 *
	 * @return     { description_of_the_return_value }
	 */
	public int[][] dotproduct() {
		int [][] dot = new int[hashdic.size()][hashdic.size()];
		int g = 0;
		for (Map<String, Integer> dictionary1 : hashdic) {
			Iterator<String> itr = dictionary1.keySet().iterator();
			int[] print = new int[hashdic.size()];
				for (int i = 0; i < print.length; i++) { //overcome null point exception
					print[i] = 0;
				}
			while (itr.hasNext()) {
				String temp = itr.next();
				int j = 0;
				for (Map<String, Integer> dictionary2 : hashdic) {
					if (dictionary2.containsKey(temp)) {
						print[j] += dictionary1.get(temp) * dictionary2.get(temp);
					} else {
						print[j] += 0;
					}
					j++;
				}
			} dot[g] = print;
			g++;
		} return dot;
	}
	/**
	 * { function vectors}
	 *
	 * @return     { description_of_the_return_value }
	 */
	public int[] vectors() {
		int k = 0;
		int[] mods = new int[hashdic.size()];
		for (Map<String, Integer> dictionary : hashdic) {
			Iterator<String> itr = dictionary.keySet().iterator();
			while (itr.hasNext()) {
				String temp = itr.next();
				mods[k] += dictionary.get(temp) * dictionary.get(temp);
			}
			k++;
		}
		return mods;
	}
	/**
	 * { file_distance }.
	 *
	 * @return     { description_of_the_return_value }
	 */
	public long[][] distance() {
		int[][] dot = dotproduct(); //dot of each file in array
		int[] vector = vectors();  // vector of each file.
		long[][] result = new long[vector.length][vector.length];
		for (int i = 0; i < dot.length; i++) {
			for(int j = 0; j < vector.length; j++) {
				result[i][j] = Math.round(dot[i][j]/ Math.sqrt(vector[i]*vector[j]) * 100.0);
			}
		}
		return result;
		}
	/**
	 * { function_print}.
	 */
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
		System.out.println("Maximum similarity is between " + filenames[file2] + " and "+ filenames[file1]);
	}
}