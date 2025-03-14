package streams;

import java.util.List;

public class SumOfSquares {

    public static int sumOfSquaresOfOddNumbers(List<Integer> numbers) {
        return numbers.stream()
                .filter(n -> n % 2 != 0) // Keep only odd numbers
                .map(n -> n * n)  // Square each odd number
                .reduce(0, Integer::sum); // Sum all squared numbers
    }

    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5);
        System.out.println(sumOfSquaresOfOddNumbers(numbers)); // Output: 35
    }
}
