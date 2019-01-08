import java.util.*;
import java.io.*;
/**
 * Class for user.
 */
class User {
	String name;
	String password;
	String question;
	String answer;
	boolean lock = false;
	public User(String n, String p, String q, String a) {
		name = n;
		password = p;
		question = q;
		answer  = a;
	}
}
class Application {

	//defining the users size
	User[] users = new User[10];
	int count = 0;
	HashMap<String,Integer> list = new HashMap<String, Integer>();
	Console console = System.console();

	/**
	 * { function_signup }.
	 */
	public void signup() {

		//reading the details from console
		console.printf("Register your account entering your details :\n");
		String name = console.readLine("Enter User Name:\n");
		char[] arr = console.readPassword("Enter Password:\n");
		String password = new String(arr);
		String question = console.readLine("Enter your secrate question?\n");
		String answer = console.readLine("Enter secrate answer:\n");

		//sending details to user function
		User temp = new User(name, password, question, answer);

		//resizing the users
		if (count/2 == users.length) {
			resize();
		}

		//storing that users in user array
		users[count] = temp;
		list.put(name,count);
		count++;
		console.printf("**YOU SUCCESSFULLY CREATED ACCOUNT**");
	}
	/**
	 * { resizing users array limit }.
	 */
	public void resize() {
		users = Arrays.copyOf(users, 2*users.length);
	}
	/**
	 * { function_login }.
	 */
	public void login() {
		String name = "";
		String password = "";
		int i;
		for (i = 3; i >0; i--) {
			//input for user and pass
			console.printf("enter username:\n");
			name = console.readLine();
			if (list.get(name) == null) {
					System.out.println("NO USER FOUND"); //check user
					return;
			}
			console.printf("enter password:\n");
			char[] arr = console.readPassword();
			password = new String(arr);

			//checking authentication
			if(checker(name, password)) { //check both
				return;
			} else {
				int pos = list.get(name); //after 3 times block
				if(users[pos].lock) {
					console.printf("---##YOUR ACCOUNT IS BLOCKED##---\n");
					return;
				}
				console.printf("Invalid User Id or Password !!!");
				console.printf("To re-enter password choose (1)\n");
				console.printf("To reset password choose (2)\n");
				int opt = Integer.parseInt(console.readLine());
				if (opt == 2) {
					reset(name);
					break;
				}
			}
		}
		if (i==0) {
			int pos = list.get(name);
			users[pos].lock = true;
			console.printf("your account got blocked\n");
		}
		
	}
	/**
	 * { function_reset }.
	 *
	 * @param      name  The uname
	 */
	public void reset(String name){
		int pos = list.get(name);
		System.out.println(users[pos].question);
		String answer = console.readLine();
		if (answer.equals(users[pos].answer)) {
			System.out.println("Enter New Password");
			users[pos].password = console.readLine();
		}

	}
	/**
	 * { function_checker }.
	 *
	 * @param      name       The name
	 * @param      password1  The password 1
	 *
	 * @return     { description_of_the_return_value }
	 */
	public boolean checker(String name, String password1) {
		int pos = list.get(name);
		if(users[pos].password.equals(password1) && !users[pos].lock) {
			System.out.println("USER AUTHENTICATED: ACCESS GRANTED");
			return true;
		}else {
			return false;
		}	
	}
}
/**
 * { class Authentication }.
 */
public final class Authentication {
	/**
	 * Constructs the object.
	 */
	private Authentication() {

	}
	/**
	 * { function_main }.
	 *
	 * @param      args  The arguments
	 */
	public static void main(final String[] args) {
		System.out.println("------------------------------");
		System.out.println("SELECT "+1+" TO **LOGIN**");
		System.out.println();
		System.out.println("SELECT "+2+" TO **SIGNUP**");
		System.out.println();
		System.out.println("SELECT q TO **QUIT**");
		System.out.println("------------------------------");
		Scanner sc = new Scanner(System.in);
		Application app = new Application();
		while(sc.hasNext()) {
		String option = sc.nextLine();
		if (option.equals("q")){
			System.out.println("--------------session terminated-------------");
			break;
		}
		else if (option.equals("1")) {
			app.login();

		}
		else if (option.equals("2")) {
			app.signup();
		} 
		else {
			System.out.println("*******Invalid Option!!!*******");
			System.out.println("------------------------------");
			System.out.println("SELECT "+1+" TO **LOGIN**");
			System.out.println();
			System.out.println("SELECT "+2+" TO **SIGNUP**");
			System.out.println();
			System.out.println("SELECT q TO **QUIT**");
			System.out.println("------------------------------");

		}
		}
	}
}