package hu.progmatic;

import hu.progmatic.model.Quiz;

@FunctionalInterface
public interface QuizStatistics {
    int calculate(Quiz quiz); // Quiz -> int
}
