package streams.filter;

import java.util.List;

public class FindFirstA {
    public static String findFirstStringStartingWithA(List<String> strings) {
        return strings.stream()
                .filter(s -> s.startsWith("A"))
                .findFirst()
                .orElse("Not found"); // Default if none found
    }

    public static void main(String[] args) {
        List<String> words = List.of("Hello", "Apple", "Banana", "Avocado");
        System.out.println(findFirstStringStartingWithA(words)); // Output: Apple
    }
}
