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

/**
 *
 * @author miguel
 */
public class MatchingStrings {

    public static List<Integer> matchingStrings(List<String> strings, List<String> queries) {
        // Write your code here
        List<Integer> results = new ArrayList<>();
        for (String query : queries) {
            results.add((int) strings.stream().filter(n -> query.equals(n)).count());
        }
        return results;
    }

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter;
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
            int stringsCount = Integer.parseInt(bufferedReader.readLine().trim());
            List<String> strings = IntStream.range(0, stringsCount).mapToObj(i -> {
                try {
                    return bufferedReader.readLine();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            })
                    .collect(Collectors.toList());
            int queriesCount = Integer.parseInt(bufferedReader.readLine().trim());
            List<String> queries = IntStream.range(0, queriesCount).mapToObj(i -> {
                try {
                    return bufferedReader.readLine();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            })
                    .collect(Collectors.toList());
            List<Integer> res = matchingStrings(strings, queries);
            bufferedWriter.write(
                    res.stream()
                            .map(Object::toString)
                            .collect(Collectors.joining("\n"))
                    + "\n"
            );
        }
        bufferedWriter.close();
    }

}
