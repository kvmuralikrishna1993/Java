/**importing scanner.
*/
import java.util.Scanner;
/**defining class.
*/
class Student {
	String name;
	String roll;
	float sub1;
	float sub2;
	float sub3;
	double avg;
Student(String nam, String rol, float a, float b, float c) {
	this.name = nam;
	this.roll = rol;
	this.sub1 = a;
	this.sub2 = b;
	this.sub3 = c;
}
	public String avg() {
		final double decimal = 10;
		this.avg = (sub1 + sub2 + sub3)/3;
		avg = (Math.floor(avg*decimal))/decimal;
		return ("\n"+roll +" "+ name +" "+"GPA --> "+avg+"\n");
	}
}
final class Studentdetails {
/** constructor
/**defining method.
@param args None
*/
    public static void main(final String[] args) {
    	System.out.println("Enter the number students");
    	Scanner s = new Scanner(System.in);
    	int n = s.nextInt();
    	System.out.println();
    	for (int i = 0; i < n; i++) {
    	//System.out.println();
    	System.out.println("Enter the name");
        String name = s.next();
        System.out.println("Enter the roll number");
        String roll = s.next();
        System.out.println("Enter marks of each subject");
        float a = s.nextFloat();
        float b = s.nextFloat();
        float c = s.nextFloat();
        Student g = new Student(name, roll, a, b, c);
        //System.out.println();
		System.out.println(g.avg());
    	}
    }

}
