package hu.progmatic;

import hu.progmatic.model.Quiz;

public class WinnerScoreExtractor implements ValueExtractor {
    @Override
    public int getValue(Quiz quiz) {
        return quiz.getWinnerScore();
    }
}
