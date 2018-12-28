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
/**
 * Class for todoist.
 */
class Todoist { 
    Task[] taskarray;
    final int val = 30;
    int taskscount;
    /**
     * Constructs the object.
     */
    Todoist() {
        taskarray = new Task[val];
        taskscount = 0;
    }
    /**
     * Adds a task.
     *
     * @param      args  The arguments
     */
    public void addTask(Task args) {
        taskarray[taskscount] = args;
        taskscount++;
    }
    /**
     * Gets the next task.
     *
     * @param      args  The arguments
     *
     * @return     The next task.
     */
    public Task getNextTask(String args) {
        for (int i = 0; i < taskscount; i++)
            if (taskarray[i].assignedTo.equals(args)) {
                if(taskarray[i].status.equals("todo")){
                    //System.out.println("y");
                    if(taskarray[i].important == true) {
                        if(taskarray[i].urgent == false) {
                            return taskarray[i];
                        }
                    }
                } 
            }
        return null;
    }
    /**
     * Gets the next task.
     *
     * @param      args  The arguments
     * @param      n     { parameter_description }
     *
     * @return     The next task.
     */
    public Task[] getNextTask(String args, int n) {
        Task[] arr =  new Task[n];
        int count  = 0;
        for (int i = 0; i < taskscount; i++)
            if (taskarray[i].assignedTo.equals(args)) {
                if(taskarray[i].status.equals("todo")){
                    if(taskarray[i].important == true) {
                        if(taskarray[i].urgent == false) {
                            arr[count] = taskarray[i];
                            count++;
                            if (count == n) {
                                break;
                            }
                        }
                    }
                } 
            }
        return arr;
    }
    /**
     * { totalTime4Completion }
     *
     * @return     { description_of_the_return_value }
     */
    public int totalTime4Completion() {
        int total = 0;
        for (int i = 0; i < taskscount; i++) {
            if(taskarray[i].status.equals("todo")){
                total += taskarray[i].timeToComplete;
            }
        }
        return total;
    }
    /**
     * Returns a string representation of the object.
     *
     * @return     String representation of the object.
     */
    public String toString() {
        String str = "";
        for (int i = 0; i < taskscount; i++) {
            String imp = (taskarray[i].important == true) ? "Important" : "Not Important";
            String urg = (taskarray[i].urgent == true) ? "Urgent" : "Not Urgent";
            str += taskarray[i].title+", "+taskarray[i].assignedTo+", "+
                Integer.toString(taskarray[i].timeToComplete)+", "+imp+", "+urg+", "+
                taskarray[i].status;
            if (i != taskscount - 1) {
                str += "\n";
            }
        } return str.substring(0,str.length());
    }
}
/**
 * Class for task.
 */
class Task {
    String title;
    String assignedTo;
    int timeToComplete;
    boolean important;
    boolean urgent;
    String status;
    /**
     * Constructs the object.
     *
     * @param      title           The title
     * @param      assignedTo      The assigned to
     * @param      timeToComplete  The time to complete
     * @param      important       The important
     * @param      urgent          The urgent
     * @param      status          The status
     */
    Task(String title, String assignedTo, int timeToComplete, boolean important,
        boolean urgent, String status) {
        this.title = title;
        this.assignedTo = assignedTo;
        this.timeToComplete = timeToComplete;
        this.important = important;
        this.urgent = urgent;
        this.status = status;
    }
    /**
     * Returns a string representation of the object.
     *
     * @return     String representation of the object.
     */
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