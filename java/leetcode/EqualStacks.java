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
 * https://www.hackerrank.com/challenges/equal-stacks/problem
 *
 * @author miguel
 */
public class EqualStacks {

    public static int[] minimalHeight(List<Integer>[] stacks) {
        int[] data = new int[2];
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < stacks.length; i++) {
            int sum = stacks[i].stream().reduce(0, Integer::sum);
            if (sum < min) {
                data[0] = i;
                data[1] = sum;
                min = sum;
            }
        }
        return data;
    }

    public static int equalStacks(List<Integer> h1, List<Integer> h2, List<Integer> h3) {
        // Write your code here
        // step 1: find the stack with minimal height. An empty stack has height zero
        // step 2: reduce the height of the other two stacks while their height be greater or equal than the other current minimal height or still has elements
        // step 3: if any of the two heights is less than than the current height, take the minimal and repeat steps 1 and 2. In other case, return the current minimal height.

        List<Integer>[] stacks = new List[3];
        stacks[0] = h1;
        stacks[1] = h2;
        stacks[2] = h3;
        int[] minimal = minimalHeight(stacks);
        int s1;
        int s2;
        int sum1;
        int sum2;
        do {
            if (minimal[1] == 0) {
                return 0;
            }
            s1 = (minimal[0] + 1) % 3;
            s2 = (minimal[0] + 2) % 3;
            sum1 = stacks[s1].stream().reduce(0, Integer::sum);
            sum2 = stacks[s2].stream().reduce(0, Integer::sum);
            while (sum1 > minimal[1]) {
                sum1 -= stacks[s1].remove(0);
            }
            while (sum2 > minimal[1]) {
                sum2 -= stacks[s2].remove(0);
            }
            if (minimal[1] == sum1
                    && minimal[1] == sum2) {
                return minimal[1];
            } else {
                if (sum1 < sum2) {
                    minimal[0] = s1;
                    minimal[1] = sum1;
                } else {
                    minimal[0] = s2;
                    minimal[1] = sum2;
                }
            }
        } while (true);
    }

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter;
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
            String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");
            int n1 = Integer.parseInt(firstMultipleInput[0]);
            int n2 = Integer.parseInt(firstMultipleInput[1]);
            int n3 = Integer.parseInt(firstMultipleInput[2]);
            List<Integer> h1 = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
            List<Integer> h2 = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
            List<Integer> h3 = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
            int result = equalStacks(h1, h2, h3);
            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }
        bufferedWriter.close();
    }

}
