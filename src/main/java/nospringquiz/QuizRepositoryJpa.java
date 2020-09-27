package nospringquiz;

import entity.Question;

import java.util.List;
import java.util.Optional;

public class QuizRepositoryJpa implements QuestionRepository {
    @Override
    public void save(Question question) {

    }

    @Override
    public Optional<Question> findByID(long id) {
        return Optional.empty();
    }

    @Override
    public void delete(Question question) {

    }

    @Override
    public void update(long id, Question question) {

    }

    @Override
    public List<Question> findAll() {
        return null;
    }
}
