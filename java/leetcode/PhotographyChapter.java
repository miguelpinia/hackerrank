package leetcode;

/**
 *
 * @author miguel
 */
public class PhotographyChapter {

    // Always guessing that we found a P
    int possibleSubsequences(int curPos, String C, int X, int Y) {
        int subseqs = 0;
        int i = curPos + X;
        int j;
        while (i < C.length() && i <= (curPos + Y)) {
            if (C.charAt(i) == 'A') {
                j = i + X;
                while (j < C.length() && j <= (i + Y)) {
                    if (C.charAt(j) == 'B') {
                        subseqs++;
                    }
                    j++;
                }
            }
            i++;
        }
        i = curPos - X;
        while (i >= 0 && i >= (curPos - Y)) {
            if (C.charAt(i) == 'A') {
                j = i - X;
                while (j >= 0 && j >= (i - Y)) {
                    if (C.charAt(j) == 'B') {
                        subseqs++;
                    }
                    j--;
                }
            }
            i--;
        }
        return subseqs;
    }

    public int getArtisticPhotographCount(int N, String C, int X, int Y) {
        // Write your code here

        // N Cells in a row, from 1 to N, represented as a String C of length N
        // C_i == "P" then it's a photographer
        // C_i == "A" then it's an actor
        // C_i == "B" then it's a backdrop
        // C_i == "." then, it must be left empty
        // To consider if a photo is artistic, it must exist a pattern of P(*[X|Y])A(*[X|Y])B or B(*[X|Y])A(*[X|Y])P
        // The distance between the photographer and the actor must be between X and Y cells (inclusive)
        // The distance between the actor and the backdrop must be between X and Y cells (inclusive)
        // The distance between 2 cells is determined by the absolute value of its difference, for example, given i and j, their distance is | i - j
        int subseqs = 0;
        for (int i = 0; i < N; i++) {
            if (C.charAt(i) == 'P') {
                subseqs += possibleSubsequences(i, C, X, Y);
            }
        }
        return subseqs;
    }

}
