package leetcode;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * https://www.hackerrank.com/challenges/icecream-parlor/problem
 *
 * @author miguel
 */
public class IcecreamParlor {

    public static List<Integer> icecreamParlor(int m, List<Integer> arr) {
        // Write your code here
        Map<Integer, Integer> set = new HashMap<>();
        for (int i = 0; i < arr.size(); i++) {
            int diff = m - arr.get(i);
            if (set.containsKey(diff)) {
                return Arrays.asList(set.get(diff), i);
            }
            set.put(arr.get(i), i);
        }
        return null;
    }

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter;
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            bufferedWriter = new BufferedWriter(new FileWriter("IceCreamParlor.txt"));
            int t = Integer.parseInt(bufferedReader.readLine().trim());
            IntStream.range(0, t).forEach(tItr -> {
                try {
                    int m = Integer.parseInt(bufferedReader.readLine().trim());

                    int n = Integer.parseInt(bufferedReader.readLine().trim());

                    List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                            .map(Integer::parseInt)
                            .collect(Collectors.toList());

                    List<Integer> result = icecreamParlor(m, arr);

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
