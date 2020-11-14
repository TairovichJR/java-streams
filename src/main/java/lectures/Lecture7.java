package lectures;


import beans.Car;
import com.google.common.collect.ImmutableList;
import mockdata.MockData;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.DoubleSummaryStatistics;
import java.util.List;

public class Lecture7 {

  @Test
  public void count() throws Exception {
    long count = MockData.getPeople()
            .stream()
            .filter(person ->  person.getGender().equalsIgnoreCase("female"))
            .count();
    System.out.println(count);
  }

  @Test
  public void min() throws Exception {
    ImmutableList<Car> cars = MockData.getCars();

    double min = cars.stream()
            .filter(car -> car.getColor().equalsIgnoreCase("yellow"))
            .mapToDouble(car -> car.getPrice())
            .min()
            .getAsDouble();
    System.out.println(min);
  }

  @Test
  public void max() throws Exception {
    double max = MockData.getCars().stream()
            .filter(car -> car.getColor().equalsIgnoreCase("yellow"))
            .mapToDouble(car -> car.getPrice())
            .max()
            .orElse(0);
    System.out.println(max);
  }


  @Test
  public void average() throws Exception {
  //  List<Car> cars = MockData.getCars();

    List<Car> cars = ImmutableList.of();
    double average = cars.stream()
            .filter(car -> car.getColor().equalsIgnoreCase("yellow"))
            .mapToDouble(Car::getPrice)
            .average()
            .orElse(0);

    System.out.println(average);
  }

  @Test
  public void sum() throws Exception {

    double sum = MockData.getCars()
            .stream()
            .mapToDouble(Car::getPrice)
            .sum();
    BigDecimal bigDecimal = BigDecimal.valueOf(sum);
    System.out.println(bigDecimal);
  }

  @Test
  public void statistics() throws Exception {

    DoubleSummaryStatistics statistics = MockData.getCars()
            .stream()
            .mapToDouble(Car::getPrice)
            .summaryStatistics();
    System.out.println(statistics);
    System.out.println(statistics.getAverage());
    System.out.println(statistics.getMax());
    System.out.println(statistics.getCount());
    System.out.println(statistics.getMin());
    System.out.println(BigDecimal.valueOf(statistics.getSum()));
  }

}