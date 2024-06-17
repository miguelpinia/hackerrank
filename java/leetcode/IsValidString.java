package leetcode;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * https://www.hackerrank.com/challenges/sherlock-and-valid-string/problem
 *
 * @author miguel
 */
public class IsValidString {

    public static String isValid(String s) {
        // Write your code here
        Map<Character, Long> freqs = s.chars()
                .mapToObj(i -> (char) i)
                .collect(Collectors.groupingBy(Function.identity(),
                        HashMap::new, Collectors.counting()));

        Map<Long, Long> counts = freqs.values().stream()
                .collect(Collectors.groupingBy(Function.identity(),
                        HashMap::new, Collectors.counting()));

        if (counts.size() == 1) {
            return "YES";
        } else if (counts.size() > 2) {
            return "NO";
        } else {
            Long[] vals = counts.values().toArray(new Long[counts.size()]);
            Long[] keys = counts.keySet().toArray(new Long[counts.size()]);
            Long minKey = Math.min(keys[0], keys[1]);
            Long maxKey = Math.max(keys[0], keys[1]);
            if ((vals[0] == 1 || vals[1] == 1)
                    && ((minKey - 1 == 0 && counts.get(minKey) == 1)
                    || maxKey - 1 == minKey)) {
                return "YES";
            }
        }
        return "NO";
    }

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter;
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
            String s = bufferedReader.readLine();
            String result = isValid(s);
            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }
        bufferedWriter.close();
    }
}
