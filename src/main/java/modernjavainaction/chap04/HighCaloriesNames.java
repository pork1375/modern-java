package modernjavainaction.chap04;

import static java.util.stream.Collectors.toList;
import static modernjavainaction.chap04.Dish.menu;

import java.util.List;
import java.util.stream.Collectors;

public class HighCaloriesNames {

  public static void main(String[] args) {
    List<String> names = menu.stream()
        .filter(dish -> {
          System.out.println("filtering " + dish.getName());
          return dish.getCalories() > 300;
        })
        .map(dish -> {
          System.out.println("mapping " + dish.getName());
          return dish.getName();
        })
        .limit(4)
        .collect(toList());
    System.out.println(names);
//      filtering pork
//      mapping pork
//      filtering beef
//      mapping beef
//      filtering chicken
//      mapping chicken
//      filtering french fries
//      mapping french fries
//      [pork, beef, chicken, french fries]


      System.out.println("---");

    // 칼로리가 300 이상인 이름 선착순 3개를 구해라
    menu.stream()
        .filter(v -> v.getCalories() > 300)   // 칼로리가 300 이상이고
        .map(v -> v.getName())    // 이름
        .limit(3)   // 선착선 3개 선택
        .forEach(System.out::println);
//      pork
//      beef
//      chicken

      System.out.println("---");

      List<String> collect = menu.stream()
              .filter(v -> v.getCalories() > 300)   // 칼로리가 300 이상이고
              .map(Dish::getName)    // 이름
              .limit(3)
              .collect(toList());
      System.out.println(collect);
//      [pork, beef, chicken]
  }



}
