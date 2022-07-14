package hu.progmatic;

import hu.progmatic.model.Quiz;

@FunctionalInterface
public interface ValueExtractor {
    int getValue(Quiz quiz); // Quiz -> int

    // default implementáció (Java 8+)
    // továbbra sincsenek osztályváltozók -> nincs állapot (osztályváltozók / mezők)
    default int getAbsValue(Quiz quiz) {
        return Math.abs(getValue(quiz));
    }
}
