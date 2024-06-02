package leetcode;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * https://www.hackerrank.com/challenges/one-month-preparation-kit-the-birthday-bar/problem
 *
 * @author miguel
 */
public class Birthday {

    public static int birthday(List<Integer> s, int d, int m) {
        // Write your code here
        int result = 0;
        int acc = 0;
        int min = s.get(0);
        for (int i = 0; i < s.size(); i++) {
            if (i < m) {
                int curr = acc + s.get(i);
                result = (curr == d) && (i + 1 == m) ? result + 1 : result;
                acc = curr;
            } else {
                int curr = (acc + s.get(i)) - min;
                min = s.get((i - m) + 1);
                result = (curr == d) ? result + 1 : result;
                acc = curr;
            }
        }
        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter;
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
            List<Integer> s = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
            String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");
            int d = Integer.parseInt(firstMultipleInput[0]);
            int m = Integer.parseInt(firstMultipleInput[1]);
            int result = birthday(s, d, m);
            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }
        bufferedWriter.close();
    }

}
