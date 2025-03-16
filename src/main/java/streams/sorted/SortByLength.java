package streams.sorted;

import java.util.List;
import java.util.stream.Collectors;

public class SortByLength {

    public static List<String> sortByLength(List<String> strings) {
        return strings.stream()
                .sorted((s1, s2) -> Integer.compare(s1.length(), s2.length()))
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        List<String> words = List.of("apple", "banana", "kiwi", "strawberry");
        System.out.println(sortByLength(words)); // Output: [kiwi, apple, banana, strawberry]
    }
}
