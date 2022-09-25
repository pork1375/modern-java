package modernjavainaction.chap03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Lambdas {

  public static void main(String... args) {
    // 간단한 예제
    // 람다 사용
    Runnable r = () -> System.out.println("Hello!");
    r.run();

    // 익명클래스를 사용해서 만들기
    Runnable r2 = new Runnable() {
      public void run() {
        System.out.println("hello 2");
      }
    };

    // 출력 메소드를 만듬
    process(r);
    process(r2);
    process(() -> System.out.println("이렇게 입력해도 실행이 된다고!!?"));

    // 람다로 거름
    List<Apple> inventory = Arrays.asList(
        new Apple(80, Color.GREEN),
        new Apple(155, Color.GREEN),
        new Apple(120, Color.RED)
    );

    // [Apple{color=GREEN, weight=80}, Apple{color=GREEN, weight=155}]
    List<Apple> greenApples = filter(inventory, (Apple a) -> Color.GREEN.equals(a.getColor()));
    System.out.println(greenApples);

    Comparator<Apple> c = (Apple a1, Apple a2) -> a1.getWeight() - a2.getWeight();

    // [Apple{color=GREEN, weight=80}, Apple{color=RED, weight=120}, Apple{color=GREEN, weight=155}]
    inventory.sort(c);
    System.out.println(inventory);
  }

  public static void process(Runnable r) {
    r.run();
  }

  public static List<Apple> filter(List<Apple> inventory, ApplePredicate p) {
    List<Apple> result = new ArrayList<>();
    for (Apple apple : inventory) {
      if (p.test(apple)) {
        result.add(apple);
      }
    }
    return result;
  }

  interface ApplePredicate {

    boolean test(Apple a);

  }

}