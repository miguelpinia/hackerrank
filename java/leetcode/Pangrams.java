package leetcode;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * https://www.hackerrank.com/challenges/pangrams/problem
 *
 * @author miguel
 */
public class Pangrams {

    public static String pangrams(String s) {
        // Write your code here
        String[] data = s.toLowerCase().replace(" ", "").split("");
        Set<String> set = new HashSet<>(Arrays.asList(data));
        return set.size() == 26 ? "pangram" : "not pangram";
    }

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter;
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
            String s = bufferedReader.readLine();
            String result = pangrams(s);
            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }
        bufferedWriter.close();
    }

}
