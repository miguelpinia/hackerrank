package leetcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * https://www.hackerrank.com/challenges/one-month-preparation-kit-mini-max-sum/problem
 *
 * @author miguel
 */
public class MiniMaxSum {

    public static void miniMaxSum(List<Integer> arr) {
        // Write your c ode here
        int arrSum = arr.stream().reduce(0, Integer::sum);
        int max = arrSum - arr.stream().min(Integer::compare).get();
        int min = arrSum - arr.stream().max(Integer::compare).get();
        System.out.println(String.format("%d %d", min, max));
    }

    public static void main(String[] args) throws IOException {
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
            miniMaxSum(arr);
        }
    }
}
