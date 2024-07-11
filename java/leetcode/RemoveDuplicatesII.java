package leetcode;

/**
 * https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/
 *
 * @author miguel
 */
public class RemoveDuplicatesII {

    public int removeDuplicates(int[] nums) {
        if (nums.length == 1) {
            return 1;
        }
        int lastViewed = nums[0];
        int count = 1;
        int repeated = 1;
        for (int i = 1; i < nums.length; i++) {
            if (lastViewed == nums[i] && repeated < 2) {
                nums[count++] = nums[i];
                repeated++;
            } else if (lastViewed < nums[i]) {
                nums[count++] = nums[i];
                lastViewed = nums[i];
                repeated = 1;
            }
        }
        return count;
    }

}
