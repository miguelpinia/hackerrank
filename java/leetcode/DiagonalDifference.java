package leetcode;

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
 * https://www.hackerrank.com/challenges/diagonal-difference/problem
 *
 * @author miguel
 */
public class DiagonalDifference {

    public static int diagonalDifference(List<List<Integer>> arr) {
        // Write your code here
        int size = arr.size();
        List<Integer> a = new ArrayList<>();
        List<Integer> b = new ArrayList<>();
        for (int i = 0; i < arr.size(); i++) {
            a.add(arr.get(i).get(i));
            b.add(arr.get(i).get(size - (i + 1)));
        }
        int sum_a = a.stream().reduce(Integer::sum).get();
        int sum_b = b.stream().reduce(Integer::sum).get();
        return Math.abs(sum_a - sum_b);
    }

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter;
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
            int n = Integer.parseInt(bufferedReader.readLine().trim());
            List<List<Integer>> arr = new ArrayList<>();
            IntStream.range(0, n).forEach(i -> {
                try {
                    arr.add(
                            Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                    .map(Integer::parseInt)
                                    .collect(Collectors.toList())
                    );
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            });
            int result = diagonalDifference(arr);
            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }
        bufferedWriter.close();
    }

}
