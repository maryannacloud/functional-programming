package streams;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class UniqueCharacters {
    public static Set<Character> getUniqueCharacters(List<String> words) {
        return words.stream()
                .flatMap(word -> word.chars().mapToObj(c -> (char) c)) // Convert each string to character stream
                .collect(Collectors.toSet());
    }

    public static void main(String[] args) {
        List<String> words = List.of("apple", "banana");
        System.out.println(getUniqueCharacters(words)); // Output: [a, p, l, e, b, n]
    }
}
