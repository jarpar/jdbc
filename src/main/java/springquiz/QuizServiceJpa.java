package springquiz;

import entity.Question;
import nospringquiz.QuizService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
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
