package more_on_streams;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Revison {
    public static void main(String[] args) throws IOException {

    //1. Integer stream
        IntStream
                .range(1, 10)
                .forEach(System.out::print);
        System.out.println();

    //2. Integer Stream with skip()
        IntStream
                .range(1,10)
                .skip(5)
                .forEach(x -> System.out.println(x) );
        System.out.println();

    //3. Integer Stream with sum
        System.out.println(IntStream.range(1,5)
                .sum());

    //4. Stream.of, sorted abd findFirst
        Stream.of("Aval","Aneri","Aleberto")
                .sorted()
                .findFirst()
                .ifPresent(System.out::println);
        //5. Stream from array, sort, filter and print
    String[] names = {"Al","Ankit","Kushal","Brent","Sarika","Amanda","Hans","Shivika","Sandy"};
        Arrays.stream(names)
                .filter(x -> x.startsWith("S"))
                .sorted()
                .forEach(System.out::println);

    //6. average of squares of an int array
        Arrays.stream(new int[]{2,4,6,8,10})
                .map(x -> x * x)
                .average()
                .ifPresent(System.out::println);
    //7. Stream from List,transform to lowercase, filter,sort and print
        List<String> people = Arrays.asList("Al","Ankit","Brent","Sarika","Amanda","Hans","Shiva");
        people.stream()
                .map(String::toLowerCase)
                .filter(x -> x.startsWith("a"))
                .sorted()
                .forEach(System.out::println);



        //8. Stream rows from text file, sort,filter and print
        Stream<String> coutries = Files.lines(Paths.get("countries.txt"));
                    coutries
                            .sorted()
                            .filter(i -> (i.length() > 1))
                            .forEach(System.out::println);
                    coutries.close();

        //9. Stream rows from text file and save to List
        List<String> coutries2 =
                Files.lines(Paths.get("countries.txt"))
                        .sorted()
                .filter(i -> (i.length() > 1))
                .collect(Collectors.toList());

        //10. Stream rows from CSV file and count
        int count = (int)Files.lines(Paths.get("data.csv"))
                .map(x -> x.split(","))
                .filter(x -> x.length == 3)
                .count();
        System.out.println(count);

        //11. Stream rows from CSV file, parse data from rows
        Files.lines(Paths.get("data.csv"))
                .map(x -> x.split(","))
                .filter(x -> x.length == 3)
                .filter(x -> Integer.parseInt(x[1]) > 15)
                .forEach(x -> System.out.println(x[0] + " " + x[1] + " " + x[2]));

        //12. Stream rows from CSV file, store fields in HashMap
        Stream<String> rows = Files.lines(Paths.get("data.csv"));
        Map<String, Integer> map = new HashMap<>();
        map = rows
                .map(x -> x.split(","))
                .filter(x -> x.length == 3)
                .collect(Collectors.toMap(
                        x -> x[0],
                        x -> Integer.parseInt(x[1])
                ));
        rows.close();
        System.out.println(map);
        //=====================  Reduction    ========================
        //13. Reduction -> sum
        double total = Stream.of(7.3,1.5,4.8)
                .reduce(0.0, (Double a, Double b) -> a+b);
        System.out.println(total);

        //14. Reduction -> summary statistics
        IntSummaryStatistics statistics = IntStream.of(7,2,9,19,88,74,3,10)
                .summaryStatistics();
        System.out.println(statistics);

    }

}
