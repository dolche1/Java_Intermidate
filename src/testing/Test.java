package testing;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Test {
    public static void main(String[] args) {
        String s = Opstrings.oper(Opstrings::horMirror, "lVHt\nJVhv\nCSbg\nyeCt");
        System.out.println(s);

    }
}
class Opstrings {

    public static String vertMirror (String strng) {
        String[] s = strng.split("\n");
        String[] reversedsS = new String[s.length];
        int counter = 0;
        for (int i = 0; i < s.length; i++) {
            reversedsS[counter++] = (i == 0) ? new StringBuilder(s[i]).reverse().toString() : "\n" + new StringBuilder(s[i]).reverse();
        }
        return Arrays.stream(reversedsS).reduce((m,n) -> m + n).get();
    }

    public static String horMirror (String strng) {
        String[] s = strng.split("\n");

        String[] reversedsS = IntStream.range(0, s.length).mapToObj(index ->
                (index == 0) ? s[s.length - 1 -index] : "\n"+s[s.length - 1 -index]).toArray(String[]::new);
        return Arrays.stream(reversedsS).reduce((m,n) -> m + n).get();
    }
    public static String oper(Operator operator, String s) {
       return operator.function(s);
    }
}
interface Operator{
    String function(String s);
}



