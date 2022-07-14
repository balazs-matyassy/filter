package hu.progmatic;

import hu.progmatic.model.Quiz;

public class Main {
    public static void main(String[] args) {
        Quiz[] quizzes = {
                new Quiz("2022.07.12.", "Enter Bar", 120, 40, 7, 28, 3000),
                new Quiz("2022.07.19.", "Enter Bar", 110, 50, 6, 36, 5000),
                new Quiz("2022.07.12.", "Rácskert", 100, 42, 4, 20, 10000),
                new Quiz("2022.07.19.", "Rácskert", 150, 52, 8, 40, 10000)
        };
    }

    private static int maxDurationValue(Quiz[] quizzes) {
        int max = Integer.MIN_VALUE;

        for (Quiz quiz : quizzes) {
            if (quiz.getDuration() > max) {
                max = quiz.getDuration();
            }
        }

        return max;
    }

    private static int maxWinnerScoreValue(Quiz[] quizzes) {
        int max = Integer.MIN_VALUE;

        for (Quiz quiz : quizzes) {
            if (quiz.getWinnerScore() > max) {
                max = quiz.getWinnerScore();
            }
        }

        return max;
    }
}
