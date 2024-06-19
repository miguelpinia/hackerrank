package leetcode;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

/**
 * https://www.hackerrank.com/challenges/lego-blocks/problem
 *
 * @author miguel
 */
public class LegoBlocks {

    private static long pow(long number, int exponent, long modulus) {
        long result = number;
        do {
            result = (result * number) % modulus;
            exponent--;
        } while (exponent > 1);
        return result;
    }

    private static void fill(List<Integer> data, int m, int modulus) {
        for (int i = 5; i < m + 1; i++) {
            long sum = data.get(i - 1)
                    + data.get(i - 2)
                    + data.get(i - 3)
                    + data.get(i - 4);
            data.add((int) mod(sum, modulus));
        }
    }

    private static long mod(long a, long b) {
        long result = a % b;
        if (result < 0) {
            result += b;
        }
        return result;
    }

    public static int legoBlocks(int n, int m) {
        // Write your code here
        if (m == 1) {
            return 1;
        }
        if (n == 1) {
            return 1 <= m && m <= 4 ? 1 : 0;
        }
        int modulus = 1000000007;
        List<Integer> combinations = new ArrayList<>();
        combinations.add(0);
        combinations.add(1);
        combinations.add(2);
        combinations.add(4);
        combinations.add(8);
        fill(combinations, m, modulus);
        List<Long> total = new ArrayList<>();
        for (Integer data : combinations) {
            total.add(pow(data, n, modulus));
        }
        //System.out.println(total);

        List<Integer> holes = new ArrayList<>();
        holes.add(0);
        holes.add(1);
        for (int i = 2; i < m + 1; i++) {
            long badLayout = 0;
            for (int j = 1; j < i; j++) {
                badLayout += holes.get(j) * total.get(i - j);
            }

            //System.out.println("BadLayout(before): " + badLayout);
            badLayout = mod(badLayout, modulus);
            //System.out.println("BadLayout(after): " + badLayout);
            holes.add((int) mod(total.get(i) - badLayout, modulus));
        }
        //System.out.println(holes);
        return holes.get(m);
        // Think in all possible combinations for one row
        // Calculate all combinations for all rows
        // Exclude all those solutions where the structure is unstable, i.e., there are straight vertical breaks
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("legoblocks.txt"));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

                int n = Integer.parseInt(firstMultipleInput[0]);

                int m = Integer.parseInt(firstMultipleInput[1]);

                int result = legoBlocks(n, m);

                bufferedWriter.write(String.valueOf(result));
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();

    }

}
