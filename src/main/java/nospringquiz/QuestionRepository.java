package nospringquiz;

import entity.Question;

import java.util.List;

public interface QuestionRepository {
    void save(Question question);

    Question findByID(long id);

    void delete(Question question);

    void update(long id, Question question);

    List<Question> findAll();

}
