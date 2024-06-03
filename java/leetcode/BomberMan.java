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
 * https://www.hackerrank.com/challenges/bomber-man/problem
 *
 * @author miguel
 */
public class BomberMan {

    public static char[][] detonate(char[][] state) {
        char[][] detonated = new char[state.length][state[0].length];
        fill(detonated);
        for (int i = 0; i < state.length; i++) {
            for (int j = 0; j < state[i].length; j++) {
                if (state[i][j] == 'O') {
                    detonated[i][j] = '.';
                    if ((i + 1) < state.length) {
                        detonated[i + 1][j] = '.';
                    }
                    if ((i - 1) >= 0) {
                        detonated[i - 1][j] = '.';
                    }
                    if ((j + 1) < state[0].length) {
                        detonated[i][j + 1] = '.';
                    }
                    if ((j - 1) >= 0) {
                        detonated[i][j - 1] = '.';
                    }

                }
            }
        }
        return detonated;
    }

    public static void fill(char[][] state) {
        for (char[] state1 : state) {
            for (int j = 0; j < state1.length; j++) {
                state1[j] = 'O';
            }
        }
    }

    public static List<String> toList(char[][] state) {
        List<String> output = new ArrayList<>();
        for (char[] is : state) {
            output.add(new String(is));
        }
        return output;
    }

    public static char[][] toCharArray(List<String> state) {
        int r = state.size();
        int c = state.get(0).length();
        char[][] output = new char[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                output[i][j] = state.get(i).charAt(j);
            }
        }
        return output;
    }

    public static List<String> bomberMan(int n, List<String> grid) {
        // Write your code here
        char[][] initialState = toCharArray(grid);
        if (n == 1) {
            return grid;
        }
        if (n % 2 == 0) {
            fill(initialState);
            return toList(initialState);
        } else if (n % 4 == 1) {
            return toList(detonate(detonate(initialState)));
        } else if (n % 4 == 3) {
            return toList(detonate(initialState));
        }
        return null;
    }

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter;
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
            String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");
            int r = Integer.parseInt(firstMultipleInput[0]);
            int c = Integer.parseInt(firstMultipleInput[1]);
            int n = Integer.parseInt(firstMultipleInput[2]);
            List<String> grid = IntStream.range(0, r).mapToObj(i -> {
                try {
                    return bufferedReader.readLine();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }).collect(Collectors.toList());
            List<String> result = bomberMan(n, grid);
            bufferedWriter.write(
                    result.stream().collect(Collectors.joining("\n"))
                    + "\n"
            );
        }
        bufferedWriter.close();
    }

}
