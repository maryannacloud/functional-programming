package streams.filter;

import java.util.List;

public class CountCharsIfNameLongerThan {

    public static long countLongNames(List<String> names) {
        return names.stream()
                .filter(name -> name.length() > 5)
                .count();
    }

    public static void main(String[] args) {
        List<String> names = List.of("John", "Elizabeth", "Sophia", "Bob");
        System.out.println(countLongNames(names)); // Output: 2
    }
}
