package nospringquiz;

import entity.Question;

public class QuizApp {
    public static void initData() {
        Question q = Question.builder()
                .body("Wybierz słowo kluczowe Javy")
                .option1("Char")
                .option2("integer")
                .option3("boolan")
                .option4("real")
                .validOption(3)
                .points(5)
                .build();
    }

    public static void main(String[] args) {

    }
}
