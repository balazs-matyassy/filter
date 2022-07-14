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

        System.out.println("Maximum hossz:");
        ValueExtractor valueExtractor = new DurationExtractor();
        System.out.println(maxValue(quizzes, valueExtractor));

        System.out.println("Maximum pontszám:");
        valueExtractor = new WinnerScoreExtractor();
        System.out.println(maxValue(quizzes, valueExtractor));

        // Anonymous class (ad-hoc)
        // Java 7-ig
        System.out.println("Maximum csapatszám:");
        valueExtractor = new ValueExtractor() { // new Main$1() [...]
            @Override
            public int getValue(Quiz quiz) {
                return quiz.getNumberOfTeams();
            }
        };
        System.out.println(maxValue(quizzes, valueExtractor));

        System.out.println("Maximum nyeremény:");
        valueExtractor = new ValueExtractor() { // new Main$2() [...]
            @Override
            public int getValue(Quiz quiz) {
                return quiz.getPrice();
            }
        };
        System.out.println(maxValue(quizzes, valueExtractor));
    }

    private static int maxValue(Quiz[] quizzes, ValueExtractor valueExtractor) {
        int max = Integer.MIN_VALUE;

        for (Quiz quiz : quizzes) {
            int value = valueExtractor.getValue(quiz);

            if (value > max) {
                max = value;
            }
        }

        return max;
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
