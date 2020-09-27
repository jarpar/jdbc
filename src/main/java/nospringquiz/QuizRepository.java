package nospringquiz;


import entity.Quiz;

import java.util.List;
import java.util.Optional;

public interface QuizRepository {
    void save(Quiz quiz);

    Optional<Quiz> findByID(long id);

    void delete(Quiz quiz);

    void update(long id, Quiz quiz);

    List<Quiz> findAll();
}
