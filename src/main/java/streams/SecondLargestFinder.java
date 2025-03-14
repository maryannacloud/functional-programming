package streams;

import java.util.List;
import java.util.Optional;

public class SecondLargestFinder {
    public static Optional<Integer> findSecondLargest(List<Integer> numbers) {
        return numbers.stream()
                .distinct()
                .sorted((a, b) -> b - a) // Sort in descending order
                .skip(1) // Skip the largest number
                .findFirst(); // Get the second largest
    }

    public static void main(String[] args) {
        List<Integer> numbers = List.of(10, 5, 20, 8, 25, 15);
        System.out.println(findSecondLargest(numbers).orElse(-1)); // Output: 20
    }
}
