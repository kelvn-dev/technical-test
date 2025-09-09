package utils;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class StringUtils {
    private static final List<Character> punctuations = Arrays.asList(
            '.', ',', '!', '?', ';', ':'
    );

    public static boolean isEmpty(String str) {
        return Objects.isNull(str) || str.trim().isEmpty();
    }

    public static boolean isNumeric(String str) {
        if (Objects.isNull(str) || str.isEmpty()) {
            return false;
        }
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static boolean endsWithPunctuation(String word) {
        return punctuations.contains(word.stripTrailing().charAt(word.length() - 1));
    }

    public static String removePunctuation(String word) {
        return word.substring(0, word.length() - 1);
    }
}
