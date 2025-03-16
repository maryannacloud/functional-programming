package streams.map;

/*
 * Task: convert a list of Strings to their lengths
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ConvertStringsToTheirLengths {

    public static void main(String[] args) {
        List<String> listOfStrings =
                new ArrayList<>(Arrays.asList("java", "javascript", "typescript", "ruby", "python"));
        List<Integer> listOfLengths = convertStringsToLength(listOfStrings);
        System.out.println(listOfLengths);

    }

    public static List<Integer> convertStringsToLength(List<String> words){

        List<Integer> lengths = words.stream()
                .map(String :: length)
                .collect(Collectors.toList());

        return lengths;
    }
}
