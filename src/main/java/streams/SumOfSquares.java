package streams;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;

public class SumOfSquares {

    public static Optional<Integer> sumOfSquaresOfOddNumbers(List<Integer> numbers) {
        return Optional.ofNullable(numbers)
                .map(list-> list.stream()
                    .filter(n -> n % 2 != 0)
                    .mapToInt(n -> n * n)
                    .sum())
                .filter(sum -> sum > 0);

        // random notes:
        // 1. .reduce() method of Stream Interface can ONLY be a terminal operator
        // 2. the 'identity' parameter equals to 0 because 0 is neutral for addition binary operation
        // 3. 'Integer::sum' is an accumulator function, in our case - .sum() method from an Integer Class
        // 3. :: is a Method Reference Operator

        // .map(n -> n * n) - original
        //.reduce(0, Integer::sum); - original
    }

    public static List<Integer> generateRandomNumbers(int size, int min, int max){
        Random random = new Random();
        return random.ints(size, min, max + 1).boxed().collect(Collectors.toList());
    }

    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>(generateRandomNumbers(5, 1, 100));
        System.out.println("Generated list: " + numbers);
        System.out.println("Sum ofSquares of Odd Numbers: " + sumOfSquaresOfOddNumbers(numbers).orElse(0));
    }
}
