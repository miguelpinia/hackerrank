package leetcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.IntStream;

/**
 * https://www.hackerrank.com/challenges/counter-game/problem
 *
 * @author miguel
 */
public class CounterGame {

    public static double log2(long n) {
        return Math.log(n) / Math.log(2);
    }

    public static String counterGame(long n) {
        // Write your code here
        if (n == 1) {
            return "Richard";
        }
        int winner = 0;
        while (n > 1) {
            int l = (int) log2(n); // 49
            System.out.println("L: " + l);
            System.out.println("DIFF: " + (n - Math.pow(2, l)));

            if (n - Math.pow(2, l) == 0) {
                n /= 2;
            } else {
                n = n - (long) Math.pow(2, l);
            }
            System.out.println("N: " + n);
            winner++;
        }
        return winner % 2 == 0 ? "Richard" : "Louise";
    }

    public static void main(String[] args) throws IOException {
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            int t = Integer.parseInt(bufferedReader.readLine().trim());
            IntStream.range(0, t).forEach(tItr -> {
                try {
                    long n = Long.parseLong(bufferedReader.readLine().trim());

                    String result = counterGame(n);

                    System.out.println("Result: " + result);

                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            });
        }

    }

}
