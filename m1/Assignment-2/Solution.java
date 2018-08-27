import java.util.Scanner;

public class Solution {
	/*
	Do not modify this main function.
	*/
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int base = scan.nextInt();
		int height = scan.nextInt();
		float area = areaOfTriangle(base, height);
		System.out.print(area);
	}
	public static float areaOfTriangle(int b, int h) {
		float area = b*h/2;
		return area;

	}
	/*
	Need to fill the areaOfTriangle function and print the output
	of fahrenheit.
	*/
}