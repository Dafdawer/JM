import java.util.Arrays;

public class Test2 {
    public static void main(String[] args) {
        int[] arr = {-2,-1,2,3,3,7,8,10};
        int[] arr1 = {0,0,1,4,13,17,20,101};
        System.out.println(Arrays.toString(mergeArrays(arr, arr1)));
    }

    public static int[] mergeArrays(int[] a1, int[] a2) {
        int[] merged = new int[a1.length + a2.length];
        int index1 = 0;
        int index2 = 0;

        while (index1 <= a1.length || index2 <= a2.length) {
            if (index1 == a1.length) {
                while (index2 < a2.length) {
                    merged[index1 + index2] = a2[index2];
                    index2++;
                }
                break;
            }
            if (index2 == a2.length) {
                while (index1 < a1.length) {
                    merged[index1 + index2] = a1[index1];
                    index1++;
                }
                break;
            }
            if (a1[index1] < a2[index2]) {
                merged[index1 + index2] = a1[index1];
                index1++;
            } else {
                merged[index1 + index2] = a2[index2];
                index2++;
            }
        }
        return merged;
    }
}
