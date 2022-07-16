package hu.progmatic;

import java.io.IOException;
import java.util.regex.Pattern;

public class MainRegex {
    // https://www.baeldung.com/regular-expressions-java
    // https://docs.oracle.com/javase/8/docs/api/java/util/regex/Pattern.html
    // https://docs.oracle.com/javase/tutorial/essential/regex/quant.html
    public static void main(String[] args) throws IOException {
        // konkrét szövegdarabok (pl. alma)
        // karakterosztályok (pl. [ab], [0-9])
        // számokat a \\d-vel lehet rövidíteni

        // * (0 és végtelen)
        // + (1 és végtelen)
        // ? (0 és 1)
        // {4}
        // {4,6}

        System.out.println(Pattern.matches("a*b", "aaaab"));
        System.out.println(Pattern.matches("a*b", "b"));
        System.out.println(Pattern.matches("a*b", "ab"));
        System.out.println(Pattern.matches("a*b", "aab"));

        System.out.println(Pattern.matches("a.*", "alma"));
        System.out.println(Pattern.matches("[ab].*", "banán"));

        System.out.println(Pattern.matches("[0-9]{6}", "123456"));
        System.out.println(Pattern.matches("\\d{6}", "123456"));

        System.out.println(Pattern.matches("[1-9]\\d{5}", "123456"));
        System.out.println(Pattern.matches("[1-9]\\d{5,6}", "023456"));

        System.out.println(Pattern.matches("alma\\d*", "alma"));
        System.out.println(Pattern.matches("alma\\d+", "alma"));
        System.out.println(Pattern.matches("alma\\d*", "alma123"));
        System.out.println(Pattern.matches("alma\\d+", "alma123"));

        System.out.println(Pattern.matches("[a-zA-Z]?", "a"));
        System.out.println(Pattern.matches("[a-zA-Z]?", "al"));
        System.out.println(Pattern.matches("[a-zA-Z]?", ""));

        // a-val kezdődő rendszámok (ABC-123)
        System.out.println(Pattern.matches("A[A-Z]{2}-\\d{3}", "ABC-123"));
        // 6 és 8 karakter közötti számok (nem kezdődhet nullával)
        System.out.println(Pattern.matches("[1-9]\\d{5,7}", "1234567"));
        // irányítószám
        System.out.println(Pattern.matches("[1-9]\\d{3}", "9400"));
        // a-val kezdődő és z-vel végződő szavak
        System.out.println(Pattern.matches("a.*z", "az"));
        System.out.println(Pattern.matches("a.*z", "alcatraz"));
        // egymás mellett 3 y-t tartalmazó szavak (pl. abyyyzzz)
        System.out.println(Pattern.matches(".*y{3}.*", "abyyyzzz"));
        System.out.println(Pattern.matches(".*y{3}.*", "yyyzzz"));

        System.out.println(Pattern.matches("\\.{4}", "...."));
        System.out.println(Pattern.matches("\\.{4}", "aaaa"));
        System.out.println(Pattern.matches("[.]{4}", "aaaa"));

        System.out.println(Pattern.matches("A[A-Z]{2}-\\d{2}9", "ABC-999"));
        System.out.println(Pattern.matches(".{2}[Cc].*", "ABC2"));
        System.out.println(Pattern.matches("CD-\\d{3}-\\d66", "CD-123-466"));


    }
}
