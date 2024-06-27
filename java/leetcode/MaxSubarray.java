package unam.mx.leetcode;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * https://www.hackerrank.com/challenges/maxsubarray/problem
 *
 * @author miguel
 */
public class MaxSubarray {

    public static List<Integer> maxSubarray(List<Integer> arr) {
        // Write your code here
        List<Integer> result = new ArrayList<>();
        int max_sar = arr.get(0);
        int curr_sar = 0;
        int max_se = Integer.MIN_VALUE;
        int curr_se = 0;
        for (Integer item : arr) {
            curr_sar = Math.max(item, item + curr_sar);
            max_sar = Math.max(curr_sar, max_sar);
            if (item > 0) {
                curr_se += item;
            }
            max_se = Math.max(item, max_se);
        }
        if (curr_se == 0) {
            curr_se = max_se;
        }
        result.add(max_sar);
        result.add(curr_se);
        return result;

    }

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter;
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
            int t = Integer.parseInt(bufferedReader.readLine().trim());
            IntStream.range(0, t).forEach(tItr -> {
                try {
                    int n = Integer.parseInt(bufferedReader.readLine().trim());

                    List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                            .map(Integer::parseInt)
                            .collect(Collectors.toList());

                    List<Integer> result = maxSubarray(arr);

                    bufferedWriter.write(
                            result.stream()
                                    .map(Object::toString)
                                    .collect(Collectors.joining(" "))
                            + "\n"
                    );
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            });
        }
        bufferedWriter.close();
    }

}
