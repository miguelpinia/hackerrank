package leetcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * https://www.hackerrank.com/challenges/one-month-preparation-kit-dynamic-array/problem
 *
 * @author miguel
 */
public class DynamicArray {

    public static List<Integer> dynamicArray(int n, List<List<Integer>> queries) {
        // Write your code here
        List<Integer> answers = new ArrayList<>();
        int lastAnswer = 0;
        int idx;
        List<List<Integer>> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            arr.add(i, new ArrayList<>());
        }
        for (List<Integer> query : queries) {
            int queryType = query.get(0);
            if (queryType == 1) {
                idx = (query.get(1) ^ lastAnswer) % n;
                arr.get(idx).add(query.get(2));
            } else if (queryType == 2) {
                idx = (query.get(1) ^ lastAnswer) % n;
                lastAnswer = arr.get(idx).get(query.get(2) % arr.get(idx).size());
                answers.add(lastAnswer);
            }
        }
        return answers;
    }

    public static void main(String[] args) throws IOException {
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");
            int n = Integer.parseInt(firstMultipleInput[0]);
            int q = Integer.parseInt(firstMultipleInput[1]);
            List<List<Integer>> queries = new ArrayList<>();
            IntStream.range(0, q).forEach(i -> {
                try {
                    queries.add(
                            Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                    .map(Integer::parseInt)
                                    .collect(Collectors.toList())
                    );
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            });

            List<Integer> result = dynamicArray(n, queries);

            System.out.println(
                    result.stream()
                            .map(Object::toString)
                            .collect(Collectors.joining("\n"))
                    + "\n"
            );
        }
    }

}
