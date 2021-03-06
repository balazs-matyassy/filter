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

        // Method reference (static)
        // Java 8+
        /* new ValueExtractor() {
            @Override
            public int getValue(Quiz quiz) {
                return getPrice(quiz);
            }
        }; */
        System.out.println("Maximum nyeremény:");
        valueExtractor = Main::getPrice;
        System.out.println(maxValue(quizzes, valueExtractor));

        // Method reference (instance)
        // Quiz::getPrice
        /* new ValueExtractor() {
            @Override
            public int getValue(Quiz quiz) {
                return quiz.getPrice();
            }
        }; */
        System.out.println("Maximum nyeremény: (2. verzió)");
        valueExtractor = Quiz::getPrice;
        System.out.println(maxValue(quizzes, valueExtractor));

        // Lambda
        // Java 8+
        System.out.println("Maximum nyeremény: (3. verzió)");
        valueExtractor = q -> q.getPrice();
        System.out.println(maxValue(quizzes, valueExtractor));

        System.out.println("1. statisztika: Maximum nyeremény");
        QuizStatistics statistics = q -> q.getPrice();
        System.out.println(statistics.calculate(quizzes[0]));

        // Nem kompatibilisek, mivel más osztályokat példányosítunk.
        // valueExtractor = statistics; ???

        // Kompatibilisek ugyanazzal a metódus referenciával,
        // de egymással megint nem, mivel más osztályokat példányosítunk.
        statistics = Main::getPrice;
    }

    // Quiz -> int
    private static int getPrice(Quiz quiz) {
        return quiz.getPrice();
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
