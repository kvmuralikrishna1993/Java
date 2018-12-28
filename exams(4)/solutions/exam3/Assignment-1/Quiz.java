import java.util.Scanner;
import java.util.Arrays;
/**
 * Exception for signaling invalid question errors.
 */
class InvalidQuestionException extends Exception {
    /**
     * Constructs the object.
     *
     * @param      s     { parameter_description }
     */
    InvalidQuestionException(final String s) {
        super(s);
    }
}
/**
 * Class for quiz.
 */
class Quiz {
/**
 * { question array }.
 */
    protected Question[] qns;
/**
 * { question count }.
 */
    protected int questioncount;
/**
 * { predefined array value }.
 */
    private final int val = 50;
/**
 * { ans array }.
 */
    private Answer[] ans;
/**
 * { ans count }.
 */
    private int anscount;
/**
 * Constructs the object.
 */
    Quiz() {
        qns = new Question[val];
        questioncount = 0;
        ans = new Answer[val];
        anscount = 0;
    }
/**
 * { function_add }.
 *
 * @param      args  The arguments
 */
    public void add(final Question args) {
        qns[questioncount] = args;
        questioncount++;
    }
/**
 * { function_add answers }.
 *
 * @param      args  The arguments
 */
    public void add(final Answer args) {
        ans[anscount] = args;
        anscount++;
    }
/**
 * { function_compare and display }.
 */
    public void compare() {
        int total = 0;
        String[] str = new String[anscount];
        if (questioncount == anscount) {
            for (int i = 0; i < questioncount; i++) {
                String[] temp = qns[i].choice.split(",");
                //Arrays.sort(temp);
                int index = Arrays.binarySearch(temp, ans[i].answer);
                //System.out.println(index);
                if (qns[i].answer == index + 1) {
                    total += qns[i].marks;
                    System.out.println(qns[i].questions);
                    System.out.println(" Correct Answer! - Marks Awarded: "
                        + Integer.toString(qns[i].marks));
                } else {
                    total += qns[i].penalty;
                    System.out.println(qns[i].questions);
                    System.out.println(" Wrong Answer! - Penalty: "
                        + Integer.toString(qns[i].penalty));
                }
            } System.out.println("Total Score: " + Integer.toString(total));
        }
    }

}
/**
 * Class for question.
 */
class Question {
/**
 * { questions }.
 */
protected String questions;
/**
 * { choice  }.
 */
protected String choice;
/**
 * { anser }.
 */
protected int answer;
/**
 * { marks}.
 */
protected int marks;
/**
 * { penalty }.
 */
protected int penalty;
/**
 * Constructs the object.
 *
 * @param      question  The question
 * @param      choices   The choices
 * @param      answers   The answers
 * @param      mark      The mark
 * @param      penaltys  The penaltys
 */
Question(final String question, final String choices,
            final int answers, final int mark, final int penaltys) {
        this.questions = question;
        this.choice = choices;
        this.answer = answers;
        this.marks = mark;
        this.penalty = penaltys;
    }
}
/**
 * Class for answer.
 */
class Answer {
/**
 * { answers}.
 */
protected String answer;
/**
 * Constructs the object.
 *
 * @param      answers  The answer
 */
    Answer(final String answers)  {
        this.answer = answers;
    }
}
    