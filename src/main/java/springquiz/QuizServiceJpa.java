package springquiz;

import entity.Question;
import nospringquiz.QuizService;

import java.util.List;

public class QuizServiceJpa implements QuizService {

    private final QuizRepository quizRepository;

    public QuizServiceJpa(QuizRepository quizRepository) {
        this.quizRepository = quizRepository;
    }

    @Override
    public List<Question> getQuiz(long id) {
        return null;
    }
}
