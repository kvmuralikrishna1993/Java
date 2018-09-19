import java.util.Scanner;
/**
 * Class for log.
 */
class Log {
    private Food[] food;
    private int foodcount;
    private Water[] water;
    private int watercount;
    private Activity[] activity;
    private int activitycount;
    private Weight[] weight;
    private int weightcount;
    private Sleep[] sleep;
    private int sleepcount;
    private final int val;
    /**
     * Constructs the object.
     */
    Log() {
        val = 100;
        food = new Food[val];
        foodcount = 0;
        water = new Water[val];
        watercount = 0;
        activity = new Activity[val];
        activitycount = 0;
        weight = new Weight[val];
        weightcount = 0;
        sleep = new Sleep[val];
        sleepcount = 0;
    }
    /**
     * { add food }.
     *
     * @param      args  The arguments
     */
    public void add(Food args) {
     food[foodcount] = args;
     foodcount++;
    }
    /**
     * { add water }.
     *
     * @param      args  The arguments
     */
    public void add(Water args) {
        water[watercount] = args;
        watercount++;
    }
    /**
     * { add activity}.
     *
     * @param      args  The arguments
     */
    public void add(Activity args) {
        activity[activitycount] = args;
        activitycount++;
    }
    /**
     * { add weight}.
     *
     * @param      args  The arguments
     */
    public void add(Weight args) {
        weight[weightcount] = args;
        weightcount++;
    }
    /**
     * { add sleep}
     *
     * @param      args  The arguments
     */
    public void add(Sleep args) {
        sleep[sleepcount] = args;
        sleepcount++;    
    }
    /**
     * { function_foodlog}.
     */
    public void foodlog() {
        System.out.println("Food");
        if (foodcount == 0) {
            System.out.println("None");
            return;
        }
        for (int i = 0; i < foodcount; i++) {
            System.out.println("Date:" + food[i].date);
            System.out.println("Time:" + food[i].time);
            System.out.println("Name:" + food[i].item);
            System.out.println("quantity:" + food[i].quantity);
        }
    }
    /**
     * { function_waterlog }.
     */
    public void waterlog() {
        System.out.println("Water");
        if (watercount == 0) {
            System.out.println("None");
            return;
        }
        for (int i = 0; i < watercount; i++) {
            System.out.println("Date:" + water[i].date);
            System.out.println("Quantity:" + water[i].waterquantity+"ml");
        }
    }
    /**
     * { function_activitylog }.
     */
    public void activitylog() {
        System.out.println("PhysicalActivity");
        if (activitycount == 0) {
            System.out.println("None");
            return;
        }
        for (int i = 0; i < activitycount; i++) {
            System.out.println("Name:" + activity[i].name);
            System.out.println("Notes:" + activity[i].notes);
            System.out.println("Date:" + activity[i].dates);
            System.out.println("Starttime:" + activity[i].starttime);
            System.out.println("Endtime:" + activity[i].endtime);
        }
    }
    /**
     * { function_weightlog}.
     */
    public void weightlog() {
        System.out.println("Weight");
        if (weightcount == 0) {
            System.out.println("None");
            return;
        }
        for (int i = 0; i < weightcount; i++) {
            System.out.println("Date:" + weight[i].date);
            System.out.println("Time:" + weight[i].time);
            System.out.println("Weight:" + weight[i].kg);
            System.out.println("Fat:" + weight[i].fat);
        }
    }
    /**
     * { function_sleeplog}.
     */
    public void sleeplog() {
        System.out.println("Sleep");
        if (sleepcount == 0) {
            System.out.println("None");
            return;
        }
        for (int i = 0; i < sleepcount; i++) {
            System.out.println("Date:" + sleep[i].date);
            System.out.println("Starttime:" + sleep[i].starttime);
            System.out.println("Endtime:" + sleep[i].endtime);
        }
    }
    /**
     * { function_summary }.
     */
    public void summary() {
        foodlog();
        waterlog();
        activitylog();
        weightlog();
        sleeplog();
    }
}
/**
 * Class for food.
 */
class Food {
    String item;
    String quantity;
    String date;
    String time;
    /**
     * Constructs the object.
     *
     * @param      item      The item
     * @param      quantity  The quantity
     * @param      date      The date
     * @param      time      The time
     */
    Food(String item, String quantity, String date, String time) {
        this.item = item;
        this.quantity = quantity;
        this.date = date;
        this.time = time;
    }
}
/**
 * Class for water.
 */
class Water {
    String waterquantity;
    String date;
    String time;
    /**
     * Constructs the object.
     *
     * @param      waterquantity  The waterquantity
     * @param      date           The date
     * @param      time           The time
     */
    Water(String waterquantity, String date, String time) {
        this.waterquantity = waterquantity;
        this.date = date;
        this.time = time;
    }
}
/**
 * Class for activity.
 */
class Activity {
    String name;
    String notes;
    String dates;
    String starttime;
    String endtime;
    /**
     * Constructs the object.
     *
     * @param      activity   The activity
     * @param      notes      The notes
     * @param      dates      The dates
     * @param      starttime  The starttime
     * @param      endtime    The endtime
     */
    Activity(String activity, String notes, String dates,
        String starttime, String endtime) {
        this.name = activity;
        this.notes = notes;
        this.dates = dates;
        this.starttime = starttime;
        this.endtime = endtime;
    }
}
/**
 * Class for weight.
 */
class Weight {
    String date;
    String time;
    String kg;
    String fat;
/**
 * Constructs the object.
 *
 * @param      date  The date
 * @param      time  The time
 * @param      kg    The kilograms
 * @param      fat   The fat
 */
    Weight(String date, String time, String kg, String fat) {
        this.date = date;
        this.time = time;
        this.kg = kg;
        this. fat = fat;
    }
}
/**
 * Class for sleep.
 */
class Sleep {
    String date;
    String starttime;
    String endtime;
/**
 * Constructs the object.
 *
 * @param      date       The date
 * @param      starttime  The starttime
 * @param      endtime    The endtime
 */
    Sleep(String date, String starttime, String endtime) {
        this.date = date;
        this.starttime = starttime;
        this.endtime = endtime;
    }
}
/**
 * Solution class for code-eval.
 */
public final class Solution {
     /**
     * Constructs the object.
     */
    private Solution() {
        // leave this blank
    }
    public static String[] spliter(String tokens) {
        String[] temp = tokens.split(",");
        return temp;
    }
    /**
     * main function to execute test cases.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
         // code to read the test cases input file
        //defining objects
        Log l = new Log();
        Scanner s = new Scanner(System.in);
        // check if there is one more line to process
        while (s.hasNext()) {
            // read the line
            String line = s.nextLine();
             // split the line using space
            String[] tokens = line.split(" ");
            switch (tokens[0]) {
                case "Food":
                //item/quantity/date/time
                l.add(new Food(spliter(tokens[1])[0], spliter(tokens[1])[1],
                    spliter(tokens[1])[2], spliter(tokens[1])[3]));
                break;
                case "Water":
                //waterquantity/date/time
                l.add(new Water(spliter(tokens[1])[0], spliter(tokens[1])[1],
                    spliter(tokens[1])[2]));
                break;
                case "PhysicalActivity":
                //name/notes/date/starttime/endtime
                l.add(new Activity(spliter(tokens[1])[0], spliter(tokens[1])[1],
                                spliter(tokens[1])[2], spliter(tokens[1])[3],
                                spliter(tokens[1])[4]));
                break;
                case "Weight":
                //date/time/kg/fat%
                l.add(new Weight(spliter(tokens[1])[0], spliter(tokens[1])[1],
                    spliter(tokens[1])[1], spliter(tokens[1])[2]));
                break;
                case "Sleep":
                //date/starttime/endtime
                l.add(new Sleep(spliter(tokens[1])[0], spliter(tokens[1])[1],
                    spliter(tokens[1])[2]));
                case "Foodlog":
                l.foodlog();
                System.out.println();
                break;
                case "Waterlog":
                l.waterlog();
                System.out.println();
                break;
                case "PhysicalActivitylog":
                l.activitylog();
                System.out.println();
                break;
                case "Weightlog":
                l.weightlog();
                System.out.println();
                break;
                case "Sleeplog":
                l.sleeplog();
                System.out.println();
                break;
                case "Summary":
                //shows all log
                l.summary();
                System.out.println();
                break;
                default:
                break;
            }
        }
    }
}
