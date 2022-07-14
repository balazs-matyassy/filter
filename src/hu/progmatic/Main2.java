package hu.progmatic;

import hu.progmatic.model.Quiz;

import java.util.function.Function;

/*
    https://docs.oracle.com/javase/8/docs/api/java/util/function/package-summary.html
    Consumer<T>: nincs visszatérési értéke
    Pl. naplózás megvalósítása (konzolos, fájl, adatbázis...)
    pl. Consumer<String> logger = System.out::println;

    Supplier<T>: nincs bemenete, csak visszaad valamit
    max keresés
    Supplier<Integer> generator = iterator::next;
    vagy visszaadhatná a Fibonacci-sorozat következő elemét...

    Predicate<T>: szürő, megadja egy objektumról, hogy megfelel-e valamilyen feltételnek

    Function<T,R>: leképezés (pl. ValueExtractor is hasonlóan működött)
 */
public class Main2 {
    public static void main(String[] args) {
        Quiz[] quizzes = {
                new Quiz("2022.07.12.", "Enter Bar", 120, 40, 7, 28, 3000),
                new Quiz("2022.07.19.", "Enter Bar", 110, 50, 6, 36, 5000),
                new Quiz("2022.07.12.", "Rácskert", 100, 42, 4, 20, 10000),
                new Quiz("2022.07.19.", "Rácskert", 150, 52, 8, 40, 10000)
        };
        Function<Quiz, Integer> getDuration = Quiz::getDuration;

        System.out.println("Maximum hossz:");
        System.out.println(maxValue(quizzes, getDuration));
    }

    private static int maxValue(Quiz[] quizzes, Function<Quiz, Integer> valueExtractor) {
        int max = Integer.MIN_VALUE;

        for (Quiz quiz : quizzes) {
            int value = valueExtractor.apply(quiz);

            if (value > max) {
                max = value;
            }
        }

        return max;
    }
}
