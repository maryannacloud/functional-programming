package streams;

import java.util.List;

public class MaxNumberFinder {
    public static int findMaxNumber(List<Integer> numbers) {
        return numbers.stream()
                .reduce(Integer.MIN_VALUE, Integer::max);
    }

    public static void main(String[] args) {
        List<Integer> numbers = List.of(5, 12, 7, 20, 10);
        System.out.println(findMaxNumber(numbers)); // Output: 20
    }
}
