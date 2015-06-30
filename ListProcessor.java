package LambdaExpressions;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.Comparator;
import java.util.function.Predicate;

public class ListProcessor {

    public static<T> List<T> filter(List<T> list, Predicate<T> p) {
        ArrayList<T> arr = new ArrayList<>();
        for (T  c : list) {
            if (p.test(c)) {
                arr.add(c);
                System.out.println(c);
            }
        }
        return arr;
    }

    public static<T> void forEach(List<T> list, Consumer<T> c) {
        for (T  i : list) {
            c.accept(i);
        }
    }

    public static<T,R> List<R> map(List<T> list, Function<T,R> f) {
        ArrayList<R> arr = new ArrayList<>();
        for (T  c : list) {
            R data = f.apply(c);
            arr.add(data);
        }
        System.out.println(arr);
        return arr;
    }
}



