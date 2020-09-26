package nospringquiz;

import entity.Question;
import jpa.MyPersistence;

public class QuizApp {
    public static void initData(QuestionRepository repository) {
        Question q = Question.builder()
                .body("Wybierz słowo kluczowe Javy")
                .option1("Char")
                .option2("integer")
                .option3("boolan")
                .option4("real")
                .validOption(3)
                .points(5)
                .build();
        repository.save(q);

        q = Question.builder()
                .body("Wybierz instrukcję przyrywającą iterację")
                .option1("switch")
                .option2("return")
                .option3("continue")
                .option4("break")
                .validOption(4)
                .points(5)
                .build();
        repository.save(q);

        q = Question.builder()
                .body("Wybierz wyrażenie, które jest fałszem")
                .option1("10 > 5 && true")
                .option2("a\".equals(\"a\")")
                .option3("true == false")
                .option4("10 != 4")
                .validOption(3)
                .points(5)
                .build();
        repository.save(q);
    }

    public static void main(String[] args) {
        QuestionRepository questionRepository = new QuestionRepositoryJpa(MyPersistence.QUIZ);

    }
}
