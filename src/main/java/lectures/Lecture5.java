package lectures;


import beans.Car;
import beans.Person;
import beans.PersonDTO;
import com.google.common.collect.ImmutableList;
import mockdata.MockData;
import org.junit.Test;

import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class Lecture5 {

  @Test
  public void understandingFilter() throws Exception {
    ImmutableList<Car> cars = MockData.getCars();

    Predicate<Car> carPredicate = car -> car.getPrice() < 10000;

    List<Car> carsFiltered = cars.stream() //entering abstraction phase
            .filter(carPredicate)
            .collect(Collectors.toList());

    carsFiltered.forEach(System.out::println);
    System.out.println(carsFiltered.size());
  }

  @Test
  public void ourFirstMapping() throws Exception {
    // transform from one data type to another
    List<Person> people = MockData.getPeople();
    Function<Person, PersonDTO> personToPersonDTOFunction =
            person -> new PersonDTO(person.getId(), person.getFirstName(), person.getAge());

    List<PersonDTO> dtos = people.stream()
            .map(personToPersonDTOFunction)
            //.map(person -> new PersonDTO(person.getId(), person.getFirstName(), person.getAge()))
            //.map(Person::map)
            .collect(Collectors.toList());

    dtos.forEach(System.out::println);
    assertThat(dtos).hasSize(1000);

  }

  @Test
  public void averageCarPrice() throws Exception {
    // calculate average of car prices
    ImmutableList<Car> cars = MockData.getCars();

    double average = cars.stream()
            .mapToDouble(car ->car.getPrice())
            //.mapToDouble(Car:: getPrice)
            .average()
            .orElse(0);
    System.out.println(average);

  }

  @Test
  public void test() throws Exception {

  }
}



