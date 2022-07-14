package hu.progmatic;

import hu.progmatic.model.Quiz;

public class DurationExtractor implements ValueExtractor {
    @Override
    public int getValue(Quiz quiz) {
        return quiz.getDuration();
    }
}
