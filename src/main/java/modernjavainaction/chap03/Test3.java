package modernjavainaction.chap03;

import java.util.function.IntFunction;

public class Test3 {
    public static void main(String[] args) {

        String str = "aa";
        int a = 1;
        int b = 2;

        IntFunction intSum = (x) -> x+1;
        System.out.println(intSum.apply(1));


        Runnable r = () -> System.out.println(a);

    }
}
