package lectures;


import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Lecture9 {

  @Test
  public void reduce() throws Exception {
    Integer[] integers = {1, 2, 3, 4, 99, 100, 121, 1302, 199};

    Integer sum = Arrays.stream(integers)
            .reduce(0, (a, b) -> a + b);

    Integer sum2 = Arrays.stream(integers).reduce(0, Integer::sum);
    System.out.println(sum);

  }

  @Test
  public void withoutFlatMap() throws Exception {
//  [Mariam, Alex, Ismail, John, Alesha, Andre, Susy, Ali]
 //   List<String> names = Lists.newArrayList();

//    for (List<String> list: arrayListOfNames) {
//      for (String name: list) {
//        names.add(name);
//      }
//    }

    List<String> allNames = arrayListOfNames.stream()
            .flatMap(name -> name.stream())
            .collect(Collectors.toList());
  }

  @Test
  public void withFlatMap() throws Exception {
//  [Mariam, Alex, Ismail, John, Alesha, Andre, Susy, Ali]
    List<String> names = arrayListOfNames.stream()
                .flatMap(name -> name.stream())
                .collect(Collectors.toList());
    System.out.println(names);
  }



  private static final List<ArrayList<String>> arrayListOfNames = Lists.newArrayList(
          Lists.newArrayList("Mariam", "Alex", "Ismail"),
          Lists.newArrayList("John", "Alesha", "Andre"),
          Lists.newArrayList("Susy", "Ali")
  );
}

