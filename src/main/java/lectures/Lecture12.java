package lectures;

import beans.Person;
import mockdata.MockData;
import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;

public class Lecture12 {
  @Test
  public void understandingCollect() throws Exception {
    List<String> emails = MockData.getPeople()
        .stream()
        .map(Person::getEmail)
        .collect(Collectors.toList());

    emails.forEach(System.out::println);
  }
}
