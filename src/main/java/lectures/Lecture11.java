package lectures;

import com.google.common.collect.ImmutableList;
import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;

public class Lecture11 {

  @Test
  public void joiningStrings() throws Exception {
    List<String> names = ImmutableList.of("anna", "john", "marcos", "helena", "yasmin");
    String s = "";
    for (String name : names) {
      s += name + ", ";
    }

    System.out.println(s.substring(0, s.length()-2));
  }

  @Test
  public void joiningStringsWithStream() throws Exception {
    List<String> names = ImmutableList.of("anna", "john", "marcos", "helena", "yasmin");

    //You can use joining by passing nothing
    String collect = names.stream()
            .collect(Collectors.joining());

    //You can also use joining by passing a delimeter
    String collect2 = names.stream()
            .map(String::toUpperCase)
            .collect(Collectors.joining(" ,"));

    System.out.println(collect);
    System.out.println(collect2);
  }
}
