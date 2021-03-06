package springquiz;

import entity.Question;
import nospringquiz.QuizController;
import nospringquiz.QuizRepository;
import nospringquiz.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.Scanner;

@SpringBootApplication
public class SpringQuizApp implements CommandLineRunner {
    final QuizService quizService;

    @Autowired
    public SpringQuizApp(QuizService quizService) {
        this.quizService = quizService;
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringQuizApp.class, args);
    }


    @Override
    public void run(String... args) throws Exception {
        QuizController controller = new QuizController(quizService, 1);
        Scanner scanner = new Scanner(System.in);
        while (true) {
            Question question = controller.next();
            System.out.println(question.getBody());
            System.out.println("1. " + question.getOptions().getOption1());
            System.out.println("2. " + question.getOptions().getOption2());
            System.out.println("3. " + question.getOptions().getOption3());
            System.out.println("4. " + question.getOptions().getOption4());
            System.out.println("0. Cofnij się do poprzedniego pytania");
            System.out.println("5. Koniec");
            int answer = scanner.nextInt();
            if (answer == 0) {
                controller.previous();
                controller.previous();
                continue;
            }
            if (answer == 5) {
                break;
            }
            controller.saveAnswer(question, answer);
        }
        System.out.println("Podsumowanie quizu: " + controller.summary());
    }
}
