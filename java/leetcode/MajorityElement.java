package leetcode;

/**
 * https://leetcode.com/problems/majority-element/description/
 *
 * @author miguel
 */
public class MajorityElement {

    public int majorityElement(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int result = nums[0];
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (count == 0) {
                result = nums[i];
            }
            if (result != nums[i]) {
                count--;
            } else {
                count++;
            }

        }
        return result;
    }

    public static void main(String[] args) {

    }

}
