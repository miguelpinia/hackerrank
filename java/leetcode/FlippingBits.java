package leetcode;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.IntStream;

/**
 * https://www.hackerrank.com/challenges/flipping-bits/problem
 *
 * @author miguel
 */
public class FlippingBits {

    public static long flippingBits(long n) {
        // Write your code here
        return ((long) Math.pow(2, 32) - 1) ^ n;
    }

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter;
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
            int q = Integer.parseInt(bufferedReader.readLine().trim());
            IntStream.range(0, q).forEach(qItr -> {
                try {
                    long n = Long.parseLong(bufferedReader.readLine().trim());

                    long result = flippingBits(n);

                    bufferedWriter.write(String.valueOf(result));
                    bufferedWriter.newLine();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            });
        }
        bufferedWriter.close();
    }

}
