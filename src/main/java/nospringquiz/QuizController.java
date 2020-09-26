package nospringquiz;

import entity.Question;

import java.util.HashMap;
import java.util.ListIterator;
import java.util.Map;

public class QuizController {
    Map<Question, Integer> answers = new HashMap<>();
    private final QuizService quizService;
    ListIterator<Question> questions;
    Question currentQuestion;

    public QuizController(QuizService quizService) {
        this.quizService = quizService;
        questions = quizService.getQuiz(0).listIterator();
    }

    public Question next() {
        if (questions.hasNext()) {

            currentQuestion = questions.next();
        }
        return currentQuestion;
    }

    public void saveAnswer(Question question, int answer) {
        answers.put(question, answer);
    }
}
