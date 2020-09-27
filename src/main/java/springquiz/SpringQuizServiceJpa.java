package springquiz;

import entity.Question;
import entity.Quiz;
import nospringquiz.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class SpringQuizServiceJpa implements QuizService {

    private final SpringQuizRepository springQuizRepository;

    @Autowired
    public SpringQuizServiceJpa(SpringQuizRepository springQuizRepository) {
        this.springQuizRepository = springQuizRepository;
    }

    @Override
    public List<Question> getQuiz(long id) {
        Optional<Quiz> quiz = springQuizRepository.findById(id);
        if (quiz.isPresent()) {
            return new ArrayList<>(quiz.get().getQuestions());
        }
        return Collections.emptyList();
    }
}
