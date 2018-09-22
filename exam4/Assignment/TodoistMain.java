import java.util.Scanner;
import java.util.Arrays;
/**
 * Exception for signaling invalid question errors.
 */
class InvalidException extends Exception {
    /**
     * Constructs the object.
     *
     * @param      s     { parameter_description }
     */
    InvalidException(final String s) {
        super(s);
    }
}

class Todoist { 
    Task[] taskarray;
    final int val = 30;
    int taskscount;
    Todoist() {
        taskarray = new Task[val];
        taskscount = 0;
    }
    public void addTask(Task args) {
        taskarray[taskscount] = args;
        taskscount++;
    }
    public String getNextTask(String args) {
        return "a";
    }
    public String totalTime4Completion() {
        return "b";
    }
    public String toString() {
        String str = "";
        for (int i = 0; i < taskscount; i++) {
            String imp = (taskarray[i].important == true) ? "Important" : "Not Important";
            String urg = (taskarray[i].important == true) ? "Urgent" : "Not Urgent";
            str += taskarray[i].title+", "+taskarray[i].assignedTo+", "+
                Integer.toString(taskarray[i].timeToComplete)+", "+imp+", "+urg+", "+
                taskarray[i].status;
            if (i != taskscount - 1) {
                str += "\n";
            }
        } return str.substring(0,str.length());
    }
}
class Task {
    String title;
    String assignedTo;
    int timeToComplete;
    boolean important;
    boolean urgent;
    String status;
    Task(String title, String assignedTo, int timeToComplete, boolean important,
        boolean urgent, String status) {
        this.title = title;
        this.assignedTo = assignedTo;
        this.timeToComplete = timeToComplete;
        this.important = important;
        this.urgent = urgent;
        this.status = status;
    }
    public String toString() {
        String str = "";
        String imp = (this.important == true) ? "Important" : "Not Important";
        String urg = (this.urgent == true) ? "Urgent" : "Not Urgent";
        str += this.title+", "+this.assignedTo+", "+
            Integer.toString(this.timeToComplete)+", "+imp+", "+urg+", "+
            this.status;
        return str;
    }
}

/**
  * write your code below this comment
  */

/**
 * Class for todoist main.
 */
public class TodoistMain {

    /**
     * Starts a test.
     */
    public static void startTest() {
        Todoist todo = new Todoist();
        Scanner s = new Scanner(System.in);
        while (s.hasNext()) {
            String[] tokens = s.nextLine().split(",");
            switch (tokens[0]) {
                case "task":
                    testTask(tokens);
                break;
                case "add-task":
                    testAddTask(todo, tokens);
                break;
                case "print-todoist":
                    System.out.println(todo);
                break;
                case "get-next":
                    System.out.println(todo.getNextTask(tokens[1]));
                break;
                /**case "get-next-n":
                    int n = Integer.parseInt(tokens[2]);
                    Task[] tasks = todo.getNextTask(tokens[1], n);
                    System.out.println(Arrays.deepToString(tasks));
                break;*/
                case "total-time":
                    System.out.println(todo.totalTime4Completion());
                break;
                default:
                break;
            }
        }
    }

    /**
     * method to test add task.
     *
     * @param      todo    The todo
     * @param      tokens  The tokens
     */
    public static void testAddTask(final Todoist todo, final String[] tokens) {
        try {
            todo.addTask(createTask(tokens));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * method to test the creation of task object.
     *
     * @param      tokens  The tokens
     */
    public static void testTask(final String[] tokens) {
        try {
            System.out.println(createTask(tokens));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Creates a task object.
     *
     * @param      tokens     The tokens
     *
     * @return     Task object
     *
     * @throws     Exception  if task inputs are invalid
     */
    public static Task createTask(final String[] tokens) throws InvalidException {
        String title = "";
        int timeToComplete = 0;
        String status= "";
        //System.out.println(tokens[1]);
        if (tokens[1].equals("")) {
            throw new InvalidException("Title not provided");
        } else {
            title = tokens[1];
        }
        String assignedTo = tokens[2];
        if (Integer.parseInt(tokens[3]) >= 1) {
            timeToComplete = Integer.parseInt(tokens[3]);
        } else {
            throw new InvalidException("Invalid timeToComplete "+tokens[3]);
        }
        boolean important = tokens[4].equals("y");
        boolean urgent = tokens[5].equals("y");
        if (tokens[6].equals("todo") || tokens[6].equals("done")) {
            status = tokens[6];
        } else {
            throw new InvalidException("Invalid status "+tokens[6]);
        }
        return new Task(
            title, assignedTo, timeToComplete, important, urgent, status);
    }
    /**
     * main method.
     *
     * @param      args  The command line arguments
     */
    public static void main(final String[] args) {
        startTest();
    }
}
