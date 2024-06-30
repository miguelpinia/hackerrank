package leetcode;

/**
 *
 * @author miguel
 */
public class MinCodeEntryTime {

    public long getMinCodeEntryTime(int N, int M, int[] C) {
        // Write your code here
        // We always begin from the position 1
        // Also, we suppose that the code is immutable
        // A solution can be:

        // Iterate over the array code:
        // Take the minimum between absolute value of the difference of the code
        // number and the current position (modulus N) and the absolute value of
        // difference between the current position and the code number (modulus
        // N). So basically, see what is the best value to reduce the amount of
        // movements performed in each rotatation.
        // We add the result of evaluate the minimum into an accumulator
        // variable.
        // N = 10
        // M = 4
        // C = [9, 4, 4, 8]
        int acc = 0;
        int start = 1;
        int val;
        for (int i = 0; i < M; i++) {
            val = C[i];                                // 9, 4, 4, 8
            int a = Math.abs(val - start) % N; //      // 8 % 10 = 8, 4 - 9 % 10 = 5, 4 - 4 % 10 = 0, 4 - 8 % 10 = 4
            int b = Math.abs((N + start) - val) % N;   // (10 + 1 - 9) % 10 = 2, 10 + 9 - 4 % 10 = 5, 10 + 4 - 4 % 10 = 0, 10 + 4 - 8 % 10 = 4
            start = val;                               // 9, 4, 4, 8
            acc += Math.min(a, b);                     // 2, 7, 7, 11
        }

        return acc;
    }

}
