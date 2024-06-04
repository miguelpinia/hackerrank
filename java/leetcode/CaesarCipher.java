package leetcode;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * https://www.hackerrank.com/challenges/caesar-cipher-1/problem
 *
 * @author miguel
 */
public class CaesarCipher {

    public static String rotate(String s, int k) {
        StringBuilder sb = new StringBuilder();
        for (int i = k; i < s.length(); i++) {
            sb.append(s.charAt(i));
        }
        for (int i = 0; i < k; i++) {
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }

    public static String caesarCipher(String s, int k) {
        // Write your code here
        k = k % 26;
        String lowerAlphabet = "abcdefghijklmnopqrstuvwxyz";
        String upperAlphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lowerRotated = rotate(lowerAlphabet, k);
        String upperRotated = rotate(upperAlphabet, k);
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char e = s.charAt(i);
            if (Character.isLetter(e)) {
                boolean isLower = Character.isLowerCase(e);
                int idx = isLower ? lowerAlphabet.indexOf(e) : upperAlphabet.indexOf(e);
                char newChar = isLower ? lowerRotated.charAt(idx) : upperRotated.charAt(idx);
                output.append(newChar);
            } else {
                output.append(e);
            }
        }
        return output.toString();
    }

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter;
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
            String s = bufferedReader.readLine();
            int k = Integer.parseInt(bufferedReader.readLine().trim());
            String result = caesarCipher(s, k);
            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }
        bufferedWriter.close();
    }

}
