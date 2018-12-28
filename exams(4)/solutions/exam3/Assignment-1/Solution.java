import java.util.Scanner;
//import java.util.Arrays;

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
    /**
     * main function to execute test cases.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
         // instantiate this Quiz
        Quiz q = new Quiz();
        boolean flag = true;
         // code to read the test cases input file
        Scanner s = new Scanner(System.in);
        // check if there is one more line to process
        while (s.hasNext()) {
            // read the line
            String line = s.nextLine();
             // split the line using space
            String[] tokens = line.split(" ");
            //System.out.println(tokens.length);
              // based on the list operation invoke the corresponding method
            switch (tokens[0]) {
                case "LOAD_QUESTIONS":
                System.out.println("|----------------|");
                System.out.println("| Load Questions |");
                System.out.println("|----------------|");
                try {
                    loadQuestions(s, q, Integer.parseInt(tokens[1]));
                } catch (InvalidQuestionException ex) {
                    System.out.println(ex.getMessage());
                    flag = false;
                }
                break;
                case "START_QUIZ":
                System.out.println("|------------|");
                System.out.println("| Start Quiz |");
                System.out.println("|------------|");
                        if (flag) {
                            startQuiz(s, q, Integer.parseInt(tokens[1]));
                        }
                break;
                case "SCORE_REPORT":
                System.out.println("|--------------|");
                System.out.println("| Score Report |");
                System.out.println("|--------------|");
                if (flag) {
                displayScore(q);
                }
                break;
                default:
                break;
            }
        }
    }
    /**
     * Loads questions.
     *
     * @param      s                         { parameter_description }
     * @param      quiz                      The quiz
     * @param      questionCount             The question count
     *
     * @throws     InvalidQuestionException  { exception_description }
     */
    public static void loadQuestions(final Scanner s, final Quiz quiz,
                    final int questionCount) throws InvalidQuestionException {
        // write your code here to read the questions from the console
        // tokenize the question line and create the question object
        // add the question objects to the quiz class
        final int inputlen = 5;
        final int queslen = 2;
        final int three = 3;
        final int four = 4;
        if (questionCount > 0) {
            String[] lines =  new String[inputlen];
            for (int i = 0; i < questionCount; i++) {
                String line = s.nextLine();
                lines = line.split(":");
                String[] choices = lines[1].split(",");
                int marks = Integer.parseInt(lines[three]);
                if (lines.length != inputlen) {
                    throw new InvalidQuestionException(
                                    "Error! Malformed question");
                } else if (lines[0].length() < queslen) {
                    throw new InvalidQuestionException(
                                    "Error! Malformed question");
                } else if (Integer.parseInt(lines[four]) > 0) {
                    throw new InvalidQuestionException("Invalid penalty for "
                                                                + lines[0]);
                } else if (choices.length < queslen) {
                    throw new InvalidQuestionException(lines[0]
                                    + " does not have enough answer choices");
                } else if (Integer.parseInt(lines[2]) > inputlen) {
                    throw new InvalidQuestionException(
                    "Error! Correct answer choice number is out of range for "
                                                + lines[0]);
                } else if (marks <= 0) {
                    throw new InvalidQuestionException("Invalid max marks for "
                                        + lines[0]);
                } else {
                    quiz.add(new Question(lines[0], lines[1],
                            Integer.parseInt(lines[2]),
                            Integer.parseInt(lines[three]),
                            Integer.parseInt(lines[four])));
                }
            } System.out.println(questionCount + " are added to the quiz");
        } else {
            throw new InvalidQuestionException("Quiz does not have questions");
        }
    }
    /**
     * Starts a quiz.
     *
     * @param      s            The scanner object for user input
     * @param      quiz         The quiz object
     * @param      answerCount  The answer count
     */
    public static void startQuiz(final Scanner s,
                    final Quiz quiz, final int answerCount) {
        // write your code here to display the quiz questions
        // read the user responses from the console
        // store the user respones in the quiz object
        final int choicelen = 4;
        String[] choices = new String[choicelen];
        for (int i = 0; i < answerCount; i++) {
            choices = quiz.qns[i].choice.split(",");
            System.out.println(quiz.qns[i].questions + "("
                        + Integer.toString(quiz.qns[i].marks) + ")");
            for (int j = 0; j < choices.length; j++) {
                System.out.print(choices[j]);
                if (j < (choices.length - 1)) {
                    System.out.print("\t");
                }
            } System.out.println();
            System.out.println();
        }
        String[] lines = new String[answerCount];   //adding answers
        for (int i = 0; i < answerCount; i++) {
            String line = s.nextLine();
            quiz.add(new Answer(line));
        }
    }
    /**
     * Displays the score report.
     *
     * @param      quiz     The quiz object
     */
    public static void displayScore(final Quiz quiz) {
        // write your code here to display the score report
        quiz.compare();
    }
}
