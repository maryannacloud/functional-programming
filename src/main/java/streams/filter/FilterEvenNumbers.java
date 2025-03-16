package streams.filter;

import java.util.List;
import java.util.stream.Collectors;

public class FilterEvenNumbers {

    public static List<Integer> filterEvenNumbers(List<Integer> numbers) {
        return numbers.stream()
                .filter(n -> n % 2 == 0)  // Keep even numbers
                .collect(Collectors.toList());  // Collect into a new List
    }

    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        System.out.println(filterEvenNumbers(numbers)); // Output: [2, 4, 6, 8, 10]
    }

}
