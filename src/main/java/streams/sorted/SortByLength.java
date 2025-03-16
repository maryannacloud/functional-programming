package streams.sorted;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SortByLength {

    public static List<String> sortByLength(List<String> strings) {
        return strings.stream()
                .sorted(Comparator.comparingInt(String::length))
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        List<String> words = List.of("apple", "banana", "kiwi", "strawberry");
        System.out.println(sortByLength(words));
    }
}
