//import java.util.Arrays;
/**
 * Class for book your show.
 */
class BookYourShow {
    public Show[] data;
    final int val = 50;
    public int showcount;
    public Patron[] allpatrons;
    public int patroncount;
/**
 * Constructs the object.
 */
    BookYourShow() {
        data = new Show[val];
        showcount = 0;
        patroncount = 0;
        allpatrons = new Patron[val];
    }
/**
 * Adds a show.
 *
 * @param      detail  The detail
 */
    public void addAShow( Show detail) {
        data[showcount] = detail;
        showcount++; 
    }
/**
 * Gets a show.
 *
 * @param      movie_name  The movie name
 * @param      date        The date
 *
 * @return     A show.
 */
    public Show getAShow(String movie_name, String date) {
        for (int i =0; i < showcount; i++) {
            if (data[i].movie_name.equals(movie_name) && data[i].date.equals(date)) {
                return data[i];
            }
        } return null;
    }
/**
 * { function_bookashow }.
 *
 * @param      movie_name  The movie name
 * @param      date        The date
 * @param      pa          { parameter_description }
 * @param      seats       The seats
 */
    public void bookAShow(String movie_name, String date, Patron pa, String[] seats) {
        Show checkshow = getAShow(movie_name,date);
        if (checkshow == null) {
            System.out.println("No show");
        } else {
            if (checkshow != null) {
            int flag = 0;
                for (int i = 0; i < seats.length; i++) {
                    for (int j = 0; j < checkshow.seats.length; j++) {
                        if (seats[i].equals(checkshow.seats[j])) {
                            checkshow.seats[j] = "N/A";
                            flag = 1;
                        }
                    }
                } for (int p = 0; p < showcount; p++) {
                    if (data[p].movie_name.equals(checkshow.movie_name) && data[p].date.equals(checkshow.date)) {
                        data[p] = checkshow;
                    }
                }
                if (flag == 1) {
                    allpatrons[patroncount] = pa;
                    //System.out.println(patroncount);
                    patroncount++;
                }
            }
        }
    }
/**
 * { function_print tickets }.
 *
 * @param      movie_name  The movie name
 * @param      date        The date
 * @param      phoneno     The phoneno
 */
    public void printTicket(String movie_name, String date, String phoneno) {
        Show checkshow = getAShow(movie_name,date);
        if (checkshow != null) {
            int flag = 0;
            //System.out.println(patroncount);
            for (int i = 0; i < patroncount; i++) {
                if (allpatrons[i].phoneno.equals(phoneno)) {
                flag = 1;
                break;
                }
            } if (flag == 1) {
                System.out.println(phoneno + " " + movie_name + " " + date);
            } else {
                System.out.println("Invalid");
            }
        } else {
            System.out.println("Invalid");
        }
    }
/**
 * Shows all.
 */
    public void showAll() {
        for (int i = 0; i < showcount; i++) {
            String st = data[i].movie_name + "," + data[i].date + ",";
            String onlyseats = "[";
            for (int j = 0; j < data[i].seats.length; j++) {
                onlyseats += data[i].seats[j];
                if (j < data[i].seats.length - 1) {
                    onlyseats += ",";
                }
           } onlyseats += "]";
           st += onlyseats;
           System.out.println(st);
        }
    }
}
/**
 * Class for show.
 */
class Show {
    String movie_name;
    String date;
    String[] seats;
/**
 * Constructs the object.
 *
 * @param      mv    { movie name }
 * @param      d     { date }
 * @param      s     { seats array }
 */
    Show(String mv,String d,String[] s) {
        this.movie_name = mv;
        this.date = d;
        this.seats = s;
    }
}
/**
 * Class for patron.
 */
class Patron {
    String pers_name;
    String phoneno;
/**
 * Constructs the object.
 *
 * @param      pers_name  The person name
 * @param      number     The number
 */
    Patron(String pers_name, String number) {
        this.pers_name = pers_name;
        this.phoneno = number;
    }
}
