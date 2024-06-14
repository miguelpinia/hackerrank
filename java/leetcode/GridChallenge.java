package leetcode;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * https://www.hackerrank.com/challenges/grid-challenge/problem
 *
 * @author miguel
 */
public class GridChallenge {

    public static String sortString(String s) {
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }

    public static String gridChallenge(List<String> grid) {
        // Write your code here
        for (int i = 0; i < grid.size(); i++) {
            grid.set(i, sortString(grid.get(i).trim()));
        }

        int n = grid.get(0).length();
        for (int i = 1; i < grid.size(); i++) {
            for (int j = 0; j < n; j++) {
                if (grid.get(i - 1).charAt(j) > grid.get(i).charAt(j)) {
                    return "NO";
                }
            }
        }
        return "YES";
    }

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter;
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
            int t = Integer.parseInt(bufferedReader.readLine().trim());
            IntStream.range(0, t).forEach(tItr -> {
                try {
                    int n = Integer.parseInt(bufferedReader.readLine().trim());

                    List<String> grid = IntStream.range(0, n).mapToObj(i -> {
                        try {
                            return bufferedReader.readLine();
                        } catch (IOException ex) {
                            throw new RuntimeException(ex);
                        }
                    })
                            .collect(Collectors.toList());

                    String result = gridChallenge(grid);

                    bufferedWriter.write(result);
                    bufferedWriter.newLine();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            });
        }
        bufferedWriter.close();
    }

}
