package lectures;


import beans.Car;
import mockdata.MockData;
import org.assertj.core.util.Lists;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Lecture8 {

  @Test
  public void simpleGrouping() throws Exception {
    //grouping by car make, which returns a map

    Map<String, List<Car>> groupedByMake = MockData.getCars()
            .stream()
            .collect(Collectors.groupingBy(car -> car.getMake()));

    //Once we get the goupedByMake map object, we can further iterate with foreach

    groupedByMake
            .forEach((make, cars) -> {
              System.out.println(make);
              cars.forEach( car-> System.out.println(car));
            } );
  }

    @Test
  public void groupingAndCounting() throws Exception {
    ArrayList<String> names = Lists
        .newArrayList(
            "John",
            "John",
            "Mariam",
            "Alex",
            "Mohammado",
            "Mohammado",
            "Vincent",
            "Alex",
            "Alex"
        );

//      Map<String, Long> counting = names
//              .stream()
//              .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
//
//      counting
//              .forEach( (name, count) -> {
//                System.out.println(name + ": " + count);
//              });

      names
              .stream()
              .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
              .forEach( (name,count) -> {
                System.out.println(name + ": " + count);
              });

    }

}