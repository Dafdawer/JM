import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;;

public class Test5 {

    public static void main(String[] args) throws FileNotFoundException {
        Reader reader = new FileReader("test.txt");

        for (Map.Entry<String, Long> entry : getSalesMap(reader).entrySet()) {
            System.out.println(entry);
        }
    }


    public static String getCallerClassAndMethodName() {

        StackTraceElement[] methods = new Exception().getStackTrace();

        if (methods.length < 3) {
            return null;
        }
        return String.format("%s#%s", methods[2].getClassName(), methods[2].getMethodName());
    }

    public static int addTwo(int a, int b) {
        System.out.println(getCallerClassAndMethodName());
        return a + b;
    }

    public static Map<String, Long> getSalesMap(Reader reader) {
        Scanner sc = new Scanner(reader);
        HashMap<String, Long> salesMap = new HashMap<>();

        while (sc.hasNext()) {
            String[] next = sc.nextLine().split("\\s");

            if (next.length < 2) {
                continue;
            }
            System.out.printf("%s, %s", next[0], next[1]);
            salesMap.merge(next[0], Long.parseLong(next[1]), (a, b) -> (a + b));
        }

        return salesMap;
    }
}
