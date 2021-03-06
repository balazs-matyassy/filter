package hu.progmatic;

import hu.progmatic.model.Quiz;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class Main3 {
    public static void main(String[] args) {
        Quiz[] quizzes = {
                new Quiz("2022.07.12.", "Enter Bar", 120, 40, 7, 28, 3000),
                new Quiz("2022.07.19.", "Enter Bar", 110, 50, 6, 36, 5000),
                new Quiz("2022.07.12.", "Rácskert", 100, 42, 4, 20, 10000),
                new Quiz("2022.07.19.", "Rácskert", 150, 52, 8, 40, 10000)
        };

        // Arrays.stream(quizzes);

        // Rácskert-es kvízek (metódus referencia)
        Predicate<Quiz> filter = Main3::isLocationRacskert;
        List<Quiz> filtered = filterQuizzes(quizzes, filter);

        for (Quiz quiz : filtered) {
            System.out.println(quiz);
        }

        System.out.println();
        System.out.println();

        // Enter Bar-os kvízek (lambda)
        filter = quiz -> quiz.getLocation().equalsIgnoreCase("Enter Bar");
        filtered = filterQuizzes(quizzes, filter);

        for (Quiz quiz : filtered) {
            System.out.println(quiz);
        }
    }

    private static boolean isLocationRacskert(Quiz quiz) {
        return quiz.getLocation().equalsIgnoreCase("Rácskert");
    }

    private static List<Quiz> filterQuizzes(Quiz[] quizzes, Predicate<Quiz> filter) {
        List<Quiz> filtered = new ArrayList<>();

        for (Quiz quiz : quizzes) {
            if (filter.test(quiz)) {
                filtered.add(quiz);
            }
        }

        return filtered;
    }
}
