package nospringquiz;

import entity.Question;
import jpa.MyPersistence;

import java.util.List;

public class QuestionRepositoryJpa implements QuestionRepository {

    private final MyPersistence persistence;

    public QuestionRepositoryJpa(MyPersistence persistence) {
        this.persistence = persistence;
    }


    @Override
    public void save(Question question) {

    }

    @Override
    public Question findByID(long id) {
        return null;
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
