package leetcode;

/**
 * https://leetcode.com/discuss/interview-question/1641064/facebook-director-of-photography-puzzle-overflow
 *
 * @author miguel
 */
public class PhotographyChapter1_2 {

    public int getArtisticPhotographCount(int N, String C, int X, int Y) {
        // Prefix sum arrays
        // Sliding windows

        int[] Ps = new int[N + 1];
        int[] Bs = new int[N + 1];
        int pstart = 0;
        int pend = 0;
        int bstart = 0;
        int bend = 0;

        for (int i = 1; i < N + 1; i++) {
            Ps[i] = Ps[i - 1] + C.charAt(i - 1) == 'P' ? 1 : 0;
            Bs[i] = Bs[i - 1] + C.charAt(i - 1) == 'B' ? 1 : 0;
        }

        int result = 0;

        for (int i = 0; i < N; i++) {
            if (C.charAt(i) == 'A') {
                pstart = i + X <= N ? i + X : N;
                pend = i + Y + 1 <= N ? i + Y + 1 : N;
                bstart = i - Y >= 0 ? i - Y : 0;
                bend = i - X + 1 >= 0 ? i - X + 1 : 0;
                result += (Ps[pend] - Ps[pstart]) * (Bs[bend] - Bs[bstart]);
                result += (Bs[pend] - Bs[pstart]) * (Ps[bend] - Bs[bstart]);
            }
        }
        return result;
    }

}
