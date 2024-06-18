package leetcode;

/**
 * https://leetcode.com/problems/jump-game-ii/description/
 *
 * @author miguel
 */
public class JumpGameII {

    public int jump(int[] nums) {
        int left = 0;
        int right = 0;
        int jumps = 0;
        while (right < nums.length - 1) {
            int farthest = 0;
            for (int i = left; i < right + 1; i++) {
                farthest = Math.max(farthest, i + nums[i]);
            }
            left = right + 1;
            right = farthest;
            jumps++;
        }
        return jumps;
    }

    public static void main(String args[]) {
        int[] case1 = new int[]{2, 3, 1, 1, 4};
        int[] case2 = new int[]{2, 3, 0, 1, 4};

        JumpGameII j = new JumpGameII();
        int sol1 = j.jump(case1);
        int sol2 = j.jump(case2);
        assert sol1 == 2;
        assert sol2 == 2;
        System.out.println("Solution 1: " + sol1);
        System.out.println("Solution 2: " + sol2);
    }

}
