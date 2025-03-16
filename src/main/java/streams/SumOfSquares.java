package streams;

import java.util.List;

public class SumOfSquares {

    public static int sumOfSquaresOfOddNumbers(List<Integer> numbers) {
        return numbers.stream()
                .filter(n -> n % 2 != 0) // Lambda Expression, which checks whether the number in the list is odd or not
                .map(n -> n * n)  // find a square for each number in a filtered list
                .reduce(0, Integer::sum); // returns an int sum of all squares

        // 1. .reduce() method of Stream Interface can ONLY be a terminal operator
        // 2. the 'identity' parameter equals to 0 because 0 is neutral for addition binary operation
        // 3. 'Integer::sum' is an accumulator function, in our case - .sum() method from an Integer Class
        // 3. :: is a Method Reference Operator
    }

    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5);
        System.out.println(sumOfSquaresOfOddNumbers(numbers)); // Output: 35
    }
}
