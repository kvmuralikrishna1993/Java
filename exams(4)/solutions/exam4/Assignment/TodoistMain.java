import java.util.Scanner;
import java.util.Arrays;
/**
  * write your code below this comment
  */

/**
 * Class for todoist main.
 */
public final class TodoistMain {
    /**
     * Constructs the object.
     */
    private TodoistMain() {

    }
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
                case "get-next-n":
                    int n = Integer.parseInt(tokens[2]);
                    Task[] tasks = todo.getNextTask(tokens[1], n);
                    System.out.println(Arrays.deepToString(tasks));
                break;
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
     * Creates a task.
     *
     * @param      tokens            The tokens
     *
     * @return     { description_of_the_return_value }
     *
     * @throws     InvalidException  { exception_description }
     */
    public static Task createTask(final String[] tokens)
                            throws InvalidException {
        final int three = 3;
        final int four = 4;
        final int five = 5;
        final int six = 6;
        String title = "";
        int timeToComplete = 0;
        String status = "";
        //System.out.println(tokens[1]);
        if (tokens[1].equals("")) {
            throw new InvalidException("Title not provided");
        } else {
            title = tokens[1];
        }
        String assignedTo = tokens[2];
        if (Integer.parseInt(tokens[three]) >= 1) {
            timeToComplete = Integer.parseInt(tokens[three]);
        } else {
            throw new InvalidException(
                "Invalid timeToComplete " + tokens[three]);
        }
        boolean important = tokens[four].equals("y");
        boolean urgent = tokens[five].equals("y");
        if (tokens[six].equals("todo") || tokens[six].equals("done")) {
            status = tokens[six];
        } else {
            throw new InvalidException("Invalid status " + tokens[six]);
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
