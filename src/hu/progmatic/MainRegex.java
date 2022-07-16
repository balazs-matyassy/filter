package hu.progmatic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.regex.Pattern;

public class MainRegex {
    // https://www.baeldung.com/regular-expressions-java
    // https://docs.oracle.com/javase/8/docs/api/java/util/regex/Pattern.html
    public static void main(String[] args) throws IOException {
        // konkrét szövegdarabok (pl. alma)
        // karakterosztályok (pl. [ab], [0-9])
        // számokat a \\d-vel lehet rövidíteni

        // * (0 és végtelen)
        // + (1 és végtelen)
        // ? (0 és 1)
        // {4}
        // {4:6}

        System.out.println(Pattern.matches("a*b", "aaaab"));
        System.out.println(Pattern.matches("a*b", "b"));
        System.out.println(Pattern.matches("a*b", "ab"));
        System.out.println(Pattern.matches("a*b", "aab"));

        System.out.println(Pattern.matches("a.*", "alma"));
        System.out.println(Pattern.matches("[ab].*", "banán"));

        System.out.println(Pattern.matches("[0-9]{6}", "123456"));
        System.out.println(Pattern.matches("\\d{6}", "123456"));

        System.out.println(Pattern.matches("[1-9]\\d{5}", "123456"));
        System.out.println(Pattern.matches("[1-9]\\d{5}", "023456"));

        System.out.println(Pattern.matches("alma\\d*", "alma"));
        System.out.println(Pattern.matches("alma\\d+", "alma"));
        System.out.println(Pattern.matches("alma\\d*", "alma123"));
        System.out.println(Pattern.matches("alma\\d+", "alma123"));

        System.out.println(Pattern.matches("[a-zA-Z]?", "a"));
        System.out.println(Pattern.matches("[a-zA-Z]?", "al"));
        System.out.println(Pattern.matches("[a-zA-Z]?", ""));


    }
}
