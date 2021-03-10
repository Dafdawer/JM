import java.util.Objects;

public class Pair <T1, T2> {
    private T1 first;
    private T2 second;

    public Pair (T1 first, T2 second) {
        this.first = first;
        this.second = second;
    }

    public T1 getFirst() {
        return first;
    }

    public T2 getSecond() {
        return second;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pair<?, ?> pair = (Pair<?, ?>) o;
        return Objects.equals(first, pair.first) &&
                Objects.equals(second, pair.second);
    }

    public static <T> Pair <T, T> of(T value1, T value2) {
        return new Pair <T, T>(value1, value2);
    }

    @Override
    public int hashCode() {
        return Objects.hash(first, second);
    }
}