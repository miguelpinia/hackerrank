package leetcode;

import java.util.Arrays;

/**
 *
 * @author miguel
 */
public class Cafeteria {

    public long getMaxAdditionalDinersCount(long N, long K, int M, long[] S) {
        // Write your code here

        // There are N seats, numbered from 1 to N from left to right.
        // Also, the distance between each diner must be K, in both sides.¿
        // Already there are M diners seated in the table
        // It's important to note that s_i diner positions are not ordered
        // Naive solution O(M log(M))
        // Sort S array positions O(M log(M))
        // iterate over ordered S array checking i and i + 1 O(M * N / K)
        // We assumed that distance between i and i + 1 is at least of K
        // We can put a new seat if there are least k free positions of distance between i (to the right) and i + 1 (to the left)
        // Taking the new seat, check if we can put new seats in middle of the new seat and the seat i + 1
        // given seats a and b, we want to know how many seats we can place between them
        // b - a must be at least 2*k + 1
        Arrays.sort(S);

        long count = 0;
        long range = 0;
        long start = 1;

        for (int i = 0; i < M; i++) {
            range = S[i] - K - start;
            if (range > 0) {
                count += Math.ceil((double) range / (K + 1));
            }
            start = S[i] + K + 1;
        }
        range = N + 1 - start;
        if (range > 0) {
            count += Math.ceil((double) range / (K + 1));
        }

        return count;
    }

}
