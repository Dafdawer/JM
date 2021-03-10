import java.util.ArrayList;
import java.util.Arrays;

public class Test4 {

    public static void main(String[] args) {
        DynamicArray<String> strings = new DynamicArray<>();
        strings.add("one");
        strings.add("two");
        strings.add("three");

        System.out.println("After add");
        System.out.println("the length is: " + strings.length());
        for (int i = 0; i < strings.length(); i++) {
            System.out.println(strings.get(i));
        }
        System.out.println();
        strings.remove(2);
        System.out.println("After remove");
        System.out.println("the length is: " + strings.length());
        for (int i = 0; i < strings.length(); i++) {
            System.out.println(strings.get(i));
        }
        ArrayList<String> a = new ArrayList<>();
    }

    public static class DynamicArray<T> {

        private T[] arr = (T[])new Object[18];

        public void add(T el) {
            arr = Arrays.copyOf(arr, arr.length + 1);
            arr[arr.length - 1] = el;
        }

        public void remove(int index) {
            for (; index < arr.length - 1; index++) {
                arr[index] = arr[index + 1];
            }
            arr = Arrays.copyOf(arr, arr.length - 1);
        }

        public T get(int index) {
            return arr[index];
        }

        public int length() {
            return arr.length;
        }
    }
}
