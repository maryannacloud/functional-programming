package streams;

import java.util.List;
import java.util.stream.Collectors;

public class UpperCaseConverter {

    public static List<String> convertToUpperCase(List<String> strings) {
        return strings.stream()
                .map(String::toUpperCase) // Convert each string to uppercase
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        List<String> words = List.of("java", "lambda", "streams");
        System.out.println(convertToUpperCase(words)); // Output: [JAVA, LAMBDA, STREAMS]
    }
}

