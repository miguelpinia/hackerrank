package leetcode;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * https://www.hackerrank.com/challenges/drawing-book/problem
 *
 * @author miguel
 */
public class PageCount {

    public static int pageCount(int n, int p) {
        // Write your code here
        int n1 = n % 2 == 0 ? n + 1 : n;
        return Math.min(p / 2, (n1 - p) / 2);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        int p = Integer.parseInt(bufferedReader.readLine().trim());

        int result = pageCount(n, p);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
