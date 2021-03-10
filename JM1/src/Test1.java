import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Test1 {
    public static void main(String[] args) {

        Deque <String> inp = new ArrayDeque<>();
        Scanner sc = new Scanner(System.in);
        int count = 2;

        while (sc.hasNext()) {
            String next = sc.next();
            if (count % 2 != 0) {
                inp.add(next);
            }
            count++;
        }
        Iterator des = inp.descendingIterator();

        while (des.hasNext()) {
            System.out.printf("%s ", des.next());
        }
    }
    public static void logging() {
        final Logger LOG = Logger.getLogger(Test1.class.getName());
        System.out.println(LOG.getName() + "; " + LOG.getClass());

        LOG.log(Level.INFO, "Все хорошо");
        LOG.log(Level.WARNING, "произошла ошибка");
    }

    public static <T> Set<T> symmetricDifference(Set<? extends T> set1, Set<? extends T> set2) {
        Set <T> a = new HashSet<>();
        a.addAll(set1);
        a.removeAll(set2);
        for (T el : set2) {
            if (!set1.contains(el)) {
                a.add(el);
            }
        }
        return a;
    }
}
