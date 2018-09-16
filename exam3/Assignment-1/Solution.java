import java.util.Scanner; 
import java.util.Arrays; 
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
class Quiz {
	public Question[] qns;
	private int questioncount;
	final int val = 50; 
	public Answer[] ans;
	private int anscount; 
	Quiz () {
		qns = new Question[val];
		questioncount = 0;
		ans = new Answer[val];
		anscount = 0;
	}
	public void add(Question args) {
		qns[questioncount] = args;
		questioncount++;
		
	}
	public void add(Answer args) {
		ans[anscount] = args;
		anscount++;    
	}
	public void compare() {
		int total = 0;
		String[] str = new String[anscount];
		if (questioncount == anscount) {
			for (int i = 0; i < questioncount; i++) {
				String[] temp = qns[i].choice.split(",");
				//Arrays.sort(temp);
				int index = Arrays.binarySearch(temp, ans[i].answer);
				//System.out.println(index);
				if (qns[i].answer == index+1) {
					total += qns[i].marks;
					System.out.println(qns[i].questions);
					System.out.println(" Correct Answer! - Marks Awarded: " + Integer.toString(qns[i].marks));
				} else {
					total += qns[i].penalty;
					System.out.println(qns[i].questions);
					System.out.println(" Wrong Answer! - Penalty: " + Integer.toString(qns[i].penalty));
				}
			} System.out.println("Total Score: "+Integer.toString(total));
		}
	}

}
class Question {
String questions;
String choice;
int answer;
int marks;
int penalty;
	Question(String questions, String choice, int answer, int marks, int penalty) {
		this.questions = questions;
		this.choice = choice;
		this.answer = answer;
		this.marks = marks;
		this.penalty = penalty;
	}
}
class Answer {
//String choice;
String answer;
	Answer(String answer)  {
		//this.choice = choice;
		this.answer = answer;
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
				} catch(InvalidQuestionException ex) {
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
				//try {
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
	 * @param      s              The scanner object for user input
	 * @param      quiz           The quiz object
	 * @param      questionCount  The question count
	 */
	public static void loadQuestions(final Scanner s, final Quiz quiz, final int questionCount)
	throws InvalidQuestionException {
		// write your code here to read the questions from the console
		// tokenize the question line and create the question object
		// add the question objects to the quiz class
		//Question[] arr = new Question[10];
		boolean flag = false;
		if (questionCount > 0) {
			String[] lines =  new String[5];
			for (int i = 0; i < questionCount; i++ ) {
				String line = s.nextLine();
				lines = line.split(":");
				String[] choices = lines[1].split(",");
				int marks = Integer.parseInt(lines[3]);
				if (lines.length != 5) {
					throw new InvalidQuestionException("Error! Malformed question");
				} else if (lines[0].length() < 2) {
					throw new InvalidQuestionException("Error! Malformed question");
				} else if (Integer.parseInt(lines[4]) > 0) {
					throw new InvalidQuestionException("Invalid penalty for "+lines[0]);
				} else if (choices.length < 2) {
					throw new InvalidQuestionException(lines[0]+" does not have enough answer choices");
				} else if (Integer.parseInt(lines[2]) > 5) {
					throw new InvalidQuestionException("Error! Correct answer choice number is out of range for "+lines[0]);
				} else if (marks <= 0) {
					throw new InvalidQuestionException("Invalid max marks for "+lines[0]);
				} else {
					quiz.add(new Question(lines[0],lines[1],Integer.parseInt(lines[2]),
						Integer.parseInt(lines[3]),Integer.parseInt(lines[4])));
				}
			} System.out.println(questionCount + " are added to the quiz");
		}
		else {
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
	public static void startQuiz(final Scanner s, final Quiz quiz, final int answerCount) {
		// write your code here to display the quiz questions
		// read the user responses from the console
		// store the user respones in the quiz object
		String[] choices = new String[4];
		for (int i = 0; i < answerCount; i++) {
			choices = quiz.qns[i].choice.split(",");
			System.out.println(quiz.qns[i].questions+"("+Integer.toString(quiz.qns[i].marks)+")");
			for(int j = 0; j < choices.length; j++) {
				System.out.print(choices[j]);
				if (j < (choices.length - 1)) {
					System.out.print("	");
				}
			} System.out.println();
			System.out.println();
		}
		String[] lines = new String[answerCount];
		for (int i = 0; i < answerCount; i++ ) {
			String line = s.nextLine();
			//lines = line.split(" ");
			quiz.add(new Answer(line));
		}
	
	}

	/**
	 * Displays the score report
	 *
	 * @param      quiz     The quiz object
	 */
	public static void displayScore(final Quiz quiz) {
		// write your code here to display the score report
		quiz.compare();
	}
}
