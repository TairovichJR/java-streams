package lectures;

import beans.Person;
import mockdata.MockData;
import org.junit.Test;

import java.util.List;
import java.util.stream.IntStream;

public class Lecture2 {

  @Test
  public void range() throws Exception {

    System.out.println("for i");
    for (int i = 0; i < 10; i++) {
      System.out.println(i);
    }

    System.out.println("exclusive");
    IntStream.range(0,10).forEach(System.out::println);

    System.out.println("inclusive");
    IntStream.rangeClosed(0,10).forEach(System.out::println);
  }

  @Test
  public void rangeIteratingLists() throws Exception {
    List<Person> people = MockData.getPeople();
    IntStream.range(0, people.size())
            .forEach(index ->{
              System.out.println(people.get(index));
            } );
  }

  @Test
  public void intStreamIterate() throws Exception {
    //iterate method from Intstream takes 2 arguments, a seed and unary operator
    //essentially seed is the starting point, and operand is how you increment
    //we are also filtering so that only even numbers are returned
    //limit accepts an int type meaning how many results you want to return, in our case 20 even numbers
    //finally we are printing with for each because it accepts a int consumer type (void)
     IntStream.iterate(1, operand -> operand + 1)
             .filter(number -> number % 2 == 0)
             .limit(20)
             .forEach(System.out::println);
  }
}
