package streams.reduce;

import java.util.List;
import java.util.Optional;

public class FindSecondLargestNumber {

    // What happens in the background?
    // 1. The Compiler verifies that stream() exists in Collection<T>
    // 2. The JRE loads StreamSupport.stream() to create a Stream
    // 3. The JVM builds a lazy processing pipeline but doesn't execute it yet.
    // 4. The JVM runs the pipeline when a terminal operation is called.

    // We are using Optional<Integer> as a return type rto avoid NullPointerException in case .findSecondLargest() returns null value
    public static Optional<Integer> findSecondLargest(List<Integer> numbers) {

        // 1. "numbers" is the data source of our Stream pipeline
        //     (PART 1 of the Stream Pipeline = Source)
        // 2. .stream() method comes from Collection interface, and it invokes Stream pipeline
        // 3. chain of methods .distinct(), .sorted() and .skip() are considered Intermediate Operations
        //    (PART 2 of the Stream Pipeline = Intermediate Operations)
        // 4. last method in the chain - .findFirst() ends the pipeline and triggers processing of data in the background
        //    (PART 3 of the Stream Pipeline = Terminal Operation)

        return numbers.stream()
                .distinct() // removes duplicates from the stream, we have to use this method before sorting
                .sorted((a, b) -> b - a)
                // .sorted() repeatedly calls the given comparison function across all elements in the list
                // the function compares two elements at a time (a, b) and determines their order
                .skip(1)
                // at this point the list is already sorted in a desc order, therefore the largest is first
                // "1" is not an index, rather the count of the elements to skip from the very beginning of the list
                .findFirst(); // after we skipped the 1st element, this method finds the "new" first element
    }

    public static void main(String[] args) {
        List<Integer> numbers = List.of(10, 5, 20, 8, 25, 15);
        System.out.println(findSecondLargest(numbers).orElse(-1)); // Output: 20
    }
}
