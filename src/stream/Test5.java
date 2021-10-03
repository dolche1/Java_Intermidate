package stream;

import java.util.Arrays;

public class Test5 {
    public static void main(String[] args) {
        int[] arr = {3, 8, 1, 5, 9, 12, 4, 21, 81, 7, 18};
        int result = Arrays.stream(arr).filter(a -> a % 2 != 0).map(a -> a % 3 == 0 ? a / 3 : a).reduce(
                (a, e) -> a + e).getAsInt();
        System.out.println(result);
    }
}
