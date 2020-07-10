package java8;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

/**
 * @author Ernest Chen
 * @date 2020/6/3.
 */
public class Stream {

    public static void main(String[] args) {

        List<String> myList =
                Arrays.asList("a1", "a2", "b1", "c2", "c1");

        myList.stream()
                .filter(s -> s.startsWith("c"))
                .map(String::toUpperCase)
                .sorted()
                .forEach(System.out::println);

        Arrays.asList("a1", "a2", "a3")
                .stream()
                .findFirst()
                .ifPresent(System.out::println);  // a1


        //Stream.of("a1", "a2", "a3").findFirst().ifPresent(System.out::println);  // a1

        IntStream.range(1, 4)
                .forEach(System.out::println);

    }
}
