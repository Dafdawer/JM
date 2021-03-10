import java.io.*;
import java.util.*;
import java.util.function.*;
import java.util.stream.*;

public class Test6 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        in.lines().map(x -> x.toLowerCase().split("[^a-zа-яA-ZА-Я|\\d]++"))
                .flatMap(Arrays::stream)
                .collect(Collectors.groupingBy(x -> x, Collectors.counting()))
                .entrySet().stream().sorted(
                (e0, e1) -> {
                    final int res = e1.getValue().compareTo(e0.getValue());
                    return res == 0 ? e0.getKey().compareTo(e1.getKey()) : res;
                }
        ).limit(10).forEach(x -> System.out.println(x.getKey()));
    }


    @FunctionalInterface
    interface NumberGenerator<T extends Number> {
        boolean cond(T arg);
    }

    public static NumberGenerator<? super Number> getGenerator() {
        return x -> x.intValue() > 0;
    }

    public static <T, U> Function<T, U> ternaryOperator(
            Predicate<? super T> condition,
            Function<? super T, ? extends U> ifTrue,
            Function<? super T, ? extends U> ifFalse) {
        return t -> condition.test(t) ? ifTrue.apply(t) : ifFalse.apply(t);
    }

    public static IntStream pseudoRandomStream(int seed) {
        return IntStream.iterate(seed, n -> ((int) (Math.pow(n, 2)) / 10) % 1000).limit(10);
    }

    public <T> void findMinMax(
            Stream<? extends T> stream,
            Comparator<? super T> order,
            BiConsumer<? super T, ? super T> minMaxConsumer) {
        java.util.ArrayList<T> list = new java.util.ArrayList<T>(stream.sorted(order).collect(Collectors.toList()));

        if (list.isEmpty()) {
            minMaxConsumer.accept(null, null);
        } else {
            minMaxConsumer.accept(list.get(0), list.get(list.size() - 1));
        }
    }


}

