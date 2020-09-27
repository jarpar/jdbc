package springquiz;

import entity.Quiz;
import nospringquiz.QuizRepository;
import nospringquiz.QuizRepositoryJpa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpringQuizRepository extends JpaRepository<Quiz, Long> {
}
