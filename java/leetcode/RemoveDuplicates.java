package leetcode;

/**
 * https://leetcode.com/problems/remove-duplicates-from-sorted-array/description/
 *
 * @author miguel
 */
public class RemoveDuplicates {

    public int removeDuplicates(int[] nums) {
        int lastViewed = nums[0];
        int count = 1;
        for (int i = 0; i < nums.length; i++) {
            if (lastViewed < nums[i]) {
                lastViewed = nums[i];
                nums[count++] = lastViewed;
            }
        }
        return count;
    }

}
