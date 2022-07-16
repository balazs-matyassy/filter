package hu.progmatic;

import hu.progmatic.model.Quiz;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Main4 {
    public static void main(String[] args) {
        // https://www.baeldung.com/java-stream-filter-lambda
        List<Quiz> quizzes = List.of(
                new Quiz("2022.07.12.", "Enter Bar", 120, 40, 7, 28, 3000),
                new Quiz("2022.07.19.", "Enter Bar", 110, 50, 6, 36, 5000),
                new Quiz("2022.07.12.", "Rácskert", 100, 42, 4, 20, 10000),
                new Quiz("2022.07.19.", "Rácskert", 150, 52, 8, 40, 10000)
        );

        /* List<Quiz> filtered = quizzes
                .stream()
                .filter(new Predicate<Quiz>() {
                    @Override
                    public boolean test(Quiz quiz) {
                        return quiz.getLocation().equalsIgnoreCase("Rácskert");
                    }
                }).toList(); */
        List<Quiz> filtered = quizzes
                .stream()
                .filter(quiz -> quiz.getLocation().equalsIgnoreCase("Rácskert"))
                .toList();

        for (Quiz quiz : filtered) {
            System.out.println(quiz);
        }
    }
}
