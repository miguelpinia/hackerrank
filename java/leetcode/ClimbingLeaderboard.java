package leetcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * https://www.hackerrank.com/challenges/climbing-the-leaderboard/problem
 *
 * @author miguel
 */
public class ClimbingLeaderboard {

    public static List<Integer> climbingLeaderboard(List<Integer> ranked,
                                                    List<Integer> player) {
        // Write your code here
        List<Integer> noDuplicates = new ArrayList<>();
        List<Integer> result = new ArrayList<>();
        int n = ranked.size();
        if (n > 1) {
            for (int i = 0; i < n; i++) {
                if (i < n - 1) {
                    if (!Objects.equals(ranked.get(i), ranked.get(i + 1))) {
                        noDuplicates.add(ranked.get(i));
                    }
                } else {
                    if (!Objects.equals(ranked.get(i - 1), ranked.get(i))) {
                        noDuplicates.add(ranked.get(i));
                    }
                }
            }
        }
        System.out.println(noDuplicates);
        int i = 0;
        int j = player.size() - 1;

        while (true) {
            System.out.println("i: " + i + ", j: " + j);
            if (i >= noDuplicates.size() && j < 0) {
                System.out.println("a");
                break;
            } else if (i >= noDuplicates.size() && j >= 0) {
                System.out.println("b");
                result.add(i + 1);
                j--;
            } else if (i < noDuplicates.size() && j < 0) {
                i++;
            } else if (noDuplicates.get(i) <= player.get(j)) {
                System.out.println("c");
                result.add(i + 1);
                j--;
            } else {
                System.out.println("d");
                i++;
            }

        }
        Collections.reverse(result);
        return result;
    }

    public static void main(String[] args) throws IOException {
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            int rankedCount = Integer.parseInt(bufferedReader.readLine().trim());

            List<Integer> ranked = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());

            int playerCount = Integer.parseInt(bufferedReader.readLine().trim());

            List<Integer> player = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());

            List<Integer> result = climbingLeaderboard(ranked, player);

            List<Integer> expected = Arrays.asList(88, 88, 87, 85, 84, 84, 83,
                                                   82, 81, 81, 80, 80, 80, 80,
                                                   79, 79, 79, 79, 79, 79, 79,
                                                   79, 77, 75, 75, 74, 73, 73,
                                                   73, 71, 71, 71, 71, 71, 71,
                                                   70, 70, 69, 69, 68, 68, 68,
                                                   68, 67, 67, 67, 66, 66, 65,
                                                   65, 64, 64, 62, 61, 61, 60,
                                                   59, 59, 59, 59, 59, 59, 58,
                                                   57, 56, 56, 55, 55, 53, 52,
                                                   52, 51, 51, 51, 51, 51, 51,
                                                   51, 51, 51, 51, 51, 51, 51,
                                                   50, 50, 50, 50, 49, 49, 48,
                                                   48, 47, 47, 47, 45, 43, 42,
                                                   42, 41, 38, 36, 36, 36, 36,
                                                   35, 35, 35, 35, 35, 35, 34,
                                                   34, 34, 33, 33, 33, 33, 33,
                                                   32, 30, 28, 28, 28, 28, 27,
                                                   27, 27, 26, 23, 23, 22, 22,
                                                   20, 20, 20, 18, 18, 15, 15,
                                                   14, 14, 13, 13, 11, 11, 10,
                                                   10, 8, 8, 7, 6, 5, 4, 4, 4,
                                                   1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
                                                   1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
                                                   1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
                                                   1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
                                                   1, 1, 1, 1);

            System.out.println("iguales? " + result.equals(expected));

            System.out.println(result.stream()
                    .map(Object::toString)
                    .collect(Collectors.joining("\n"))
                    + "\n");
        }
    }
}
