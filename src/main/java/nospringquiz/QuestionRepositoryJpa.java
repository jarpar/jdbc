package nospringquiz;

import entity.Question;
import jpa.MyPersistence;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

public class QuestionRepositoryJpa implements QuestionRepository {

    private final MyPersistence persistence;

    public QuestionRepositoryJpa(MyPersistence persistence) {
        this.persistence = persistence;
    }


    @Override
    public void save(Question question) {
        EntityManager em = persistence.getEntityManager();
        em.getTransaction().begin();
        em.persist(question);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public Optional<Question> findByID(long id) {
        EntityManager em = persistence.getEntityManager();
        Optional<Question> question = Optional.ofNullable(em.find(Question.class, id));
        em.close();
        return question;
    }

    @Override
    public void delete(Question question) {
        EntityManager em = persistence.getEntityManager();
        em.getTransaction().begin();
        em.remove(question);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void update(long id, Question question) {
        EntityManager em = persistence.getEntityManager();
        em.getTransaction().begin();
        Question entity = em.find(Question.class, id);
        if (entity == null) {
            em.getTransaction().commit();
            em.close();
            return;
        }


    }

    @Override
    public List<Question> findAll() {
        return null;
    }
}
