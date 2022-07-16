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
        int max = getMax(
                quizzes,
                new Predicate<Quiz>() {
                    @Override
                    public boolean test(Quiz quiz) {
                        return quiz.getDate().equals("2022.07.12.");
                    }
                },
                new Function<Quiz, Integer>() {
                    @Override
                    public Integer apply(Quiz quiz) {
                        return quiz.getPrice();
                    }
                });

        System.out.println("A 2022.07.12-én játszott kvízek max nyereménye: " + max);

        // összes kvíz max hossza
        // (method reference)
        // public Integer apply(Quiz quiz) {
        //  return getQuizDuration(quiz);
        // }
        max = getMax(quizzes, MainPractice::allQuizzes, MainPractice::getQuizDuration);
        System.out.println("Összes kvíz max hossza: " + max);

        // public Integer apply(Quiz quiz) {
        //  return quiz.getDuration();
        // }
        max = getMax(quizzes, MainPractice::allQuizzes, Quiz::getDuration);
        System.out.println("Összes kvíz max hossza: " + max);

        // Enter Bar-ban játszott kvízek max pontszáma
        // (lambda)
        max = getMax(
                quizzes,
                quiz -> quiz.getLocation().equals("Enter Bar"),
                qz -> qz.getWinnerScore());
        System.out.println("Az Enter Barban játszott kvízek max pontszáma: " + max);
    }

    private static boolean allQuizzes(Quiz quiz) {
        return true;
    }

    private static int getQuizDuration(Quiz quiz) {
        return quiz.getDuration();
    }

    private static int getMax(List<Quiz> quizzes, Predicate<Quiz> where, Function<Quiz, Integer> select) {
        int max = Integer.MIN_VALUE;

        for (Quiz quiz : quizzes) {
            if (where.test(quiz)) {
                int value = select.apply(quiz);

                if (value > max) {
                    max = value;
                }
            }
        }

        return max;
    }
}
