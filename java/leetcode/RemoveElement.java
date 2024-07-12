package leetcode;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/remove-element/
 *
 * @author miguel
 */
public class RemoveElement {

    // Most intuitive solution
    /*
    public int removeElement(int[] nums, int val) {
        int MAXIMUM = Integer.MAX_VALUE;
        int not_k = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == val) {
                nums[i] = MAXIMUM;
                not_k++;
            }
        }
        Arrays.sort(nums);
        return nums.length - not_k;
    }
     */
    // Simplest solution
    public int removeElementII(int[] nums, int val) {
        int pos = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[pos++] = nums[i];
            }
        }
        return pos;
    }

    @SuppressWarnings("empty-statement")
    public int removeElement(int[] nums, int val) {
        if (nums.length == 1 && val == nums[0]) {
            nums = new int[0];
        }
        int tail = nums.length - 1;
        int k = 0;
        for (int i = 0; i < tail;) {
            if (tail < 0) {
                break;
            }
            if (nums[i] == val) {
                if (val == nums[tail]) {
                    tail--;
                    k++;
                    continue;
                }
                int temp = nums[tail];
                nums[tail] = nums[i];
                nums[i] = temp;
                k++;
                tail--;
            }
            i++;
        }
        int result = nums.length - k;
        if (result == 0) {
            nums = new int[0];
        }
        return nums.length - k;
    }

    public static void main(String[] args) {
        int[] intArray = new int[]{3, 3};
        RemoveElement re = new RemoveElement();
        int k = re.removeElement(intArray, 3);
        System.out.println("K: " + k);
        //Arrays.sort(intArray);
        System.out.println(Arrays.toString(intArray));
    }

}
