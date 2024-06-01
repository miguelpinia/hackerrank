package leetcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * https://www.hackerrank.com/challenges/sherlock-and-array/problem
 * @author miguel
 */
public class BalancedSums {

    public static String balancedSums(List<Integer> arr) {
        // Write your code here
        // [1 1 4 1 1]
        if (arr.size() == 1) {
            return "YES";
        }
        int leftSum = 0;
        int rightSum = arr.stream().reduce(0, (a, b) -> a + b);
        for (int i = 0; i < arr.size(); i++) {
            rightSum -= arr.get(i);
            if (rightSum == leftSum) {
                return "YES";
            }
            leftSum += arr.get(i);
        }
        return "NO";
    }

    public static void main(String[] args) throws IOException {
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            int T = Integer.parseInt(bufferedReader.readLine().trim());

            IntStream.range(0, T).forEach(TItr -> {
                try {
                    int n = Integer.parseInt(bufferedReader.readLine().trim());

                    List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                            .map(Integer::parseInt)
                            .collect(Collectors.toList());

                    String result = balancedSums(arr);

                    System.out.println("Result: " + result);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            });
        }
    }

}
