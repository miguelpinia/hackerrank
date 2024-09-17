package leetcode;

/**
 * 238. Product of Array Except Self Given an integer array nums, return an
 * array answer such that answer[i] is equal to the product of all the elements
 * of nums except nums[i].
 *
 * The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit
 * integer.
 *
 * You must write an algorithm that runs in O(n) time and without using the
 * division operation
 *
 * Example 1:
 *
 * Input: nums = [1,2,3,4] Output: [24,12,8,6] Example 2:
 *
 * Input: nums = [-1,1,0,-3,3] Output: [0,0,9,0,0]
 *
 * Constraints:
 *
 * 2 <= nums.length <= 105
 *
 * -30 <= nums[i] <= 30
 *
 * The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit
 * integer.
 *
 * Follow up: Can you solve the problem in O(1) extra space complexity? (The
 * output array does not count as extra space for space complexity analysis.)
 */
public class ProductOfArrayExceptSelf {

    public int[] productExceptSelf(int[] nums) {
        int size = nums.length;
        int[] answer = new int[size];
        int acc = 0, tmp;

        answer[size - 2] = nums[size - 1];
        for (int i = size - 3; i >= 0; i--) {
            answer[i] = answer[i + 1] * nums[i + 1];
        }
        acc = nums[0];
        nums[0] = 0;

        for (int i = 1; i < size; i++) {
            tmp = acc * nums[i];
            nums[i] = acc;
            acc = tmp;
        }
        for (int i = 1; i < size - 1; i++) {
            answer[i] *= nums[i];
        }
        answer[size - 1] = nums[size - 1];
        return answer;
    }

    public int[] productExceptSelf2(int nums[]) {
        int size = nums.length;
        int[] answer = new int[size];
        answer[0] = 1;
        for (int i = 1; i < size; i++) {
            answer[i] = answer[i - 1] * nums[i - 1];
        }
        for (int i = size - 1, r = 1; i >= 0; i--) {
            answer[i] = answer[i] * r;
            r *= nums[i];
        }
        return answer;
    }

}
