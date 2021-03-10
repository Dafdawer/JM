
public class Test7 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        for (int i = 2; i < 5; i++) {
            try {
                System.out.println(arr[i]);
            } catch (IndexOutOfBoundsException e) {
                System.out.println("i'm in");
            }
            if (i == 4) {
                throw new IndexOutOfBoundsException("gotcha");
            }
        }
 }
}
