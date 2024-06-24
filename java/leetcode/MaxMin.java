package leetcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * https://www.hackerrank.com/challenges/angry-children/problem
 *
 * @author miguel
 */
public class MaxMin {

    public static int maxMin(int k, List<Integer> arr) {
        // Write your code here<
        Collections.sort(arr);
        int size = arr.size();
        int minimum = Integer.MAX_VALUE;
        for (int i = 0; i < (size - k) + 1; i++) {
            int difference = arr.get(i + k - 1) - arr.get(i);
            minimum = difference < minimum ? difference : minimum;
        }
        return minimum;
    }

    public static void main(String[] args) throws IOException {
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(bufferedReader.readLine().trim());
            int k = Integer.parseInt(bufferedReader.readLine().trim());
            List<Integer> arr = IntStream.range(0, n).mapToObj(i -> {
                try {
                    return bufferedReader.readLine().replaceAll("\\s+$", "");
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            })
                    .map(String::trim)
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
            int result = maxMin(k, arr);
            System.out.println(result);
        }
    }

}
