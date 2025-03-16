package streams.collect;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Person {

    String name;
    int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String toString() {
        return name;
    }
}

    class GroupByAge {
        public static Map<String, List<Person>> groupByAgeRange(List<Person> people) {
            return people.stream()
                    .collect(Collectors.groupingBy(p -> {
                        if (p.age < 18) return "<18";
                        else if (p.age <= 25) return "18-25";
                        else return ">25";
                    }));
        }

        public static void main(String[] args) {
            List<Person> people = List.of(
                    new Person("Alice", 15),
                    new Person("Bob", 22),
                    new Person("Charlie", 30),
                    new Person("David", 19)
            );

            System.out.println(groupByAgeRange(people));
        }
}
