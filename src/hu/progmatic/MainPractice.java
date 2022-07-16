package hu.progmatic;

import hu.progmatic.model.Quiz;

import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class MainPractice {
    public static void main(String[] args) {
        List<Quiz> quizzes = List.of(
                new Quiz("2022.07.12.", "Enter Bar", 120, 40, 7, 28, 3000),
                new Quiz("2022.07.19.", "Enter Bar", 110, 50, 6, 36, 5000),
                new Quiz("2022.07.12.", "Rácskert", 100, 42, 4, 20, 9000),
                new Quiz("2022.07.19.", "Rácskert", 150, 52, 8, 40, 10000)
        );

        // 2022.07.12-én játszott kvízek max nyereménye
        // (anonymous class)

        // összes kvíz max hossza
        // (method reference)

        // Enter Bar-ban játszott kvízek max pontszáma
        // (lambda)

    }

    private static int getMax(List<Quiz> quizzes, Predicate<Quiz> filter, Function<Quiz, Integer> extractor) {
        int max = Integer.MIN_VALUE;

        for (Quiz quiz : quizzes) {
            if (filter.test(quiz)) {
                int value = extractor.apply(quiz);

                if (value > max) {
                    max = value;
                }
            }
        }

        return max;
    }
}
