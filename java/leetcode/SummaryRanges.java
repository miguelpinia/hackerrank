
import java.util.ArrayList;
import java.util.List;

/*
 * Copyright (c) 2024 miguel.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    miguel - initial API and implementation and/or initial documentation
 */
/**
 *
 * @author miguel
 */
public class SummaryRanges {

    /**
     * Oms ¨beats 100%, 41.5mb beats 82.19%
     *
     * @param nums
     * @return
     */
    public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        int j;
        int curr;
        for (int i = 0; i < nums.length; i++) {
            sb.append(nums[i]);
            j = i + 1;
            curr = nums[i];
            while (j < nums.length && curr + 1 == nums[j]) {
                curr = nums[j];
                j++;
            }
            if (curr != nums[i]) {
                sb.append("->");
                sb.append(curr);
            }
            i = j - 1;
            result.add(sb.toString());
            sb = new StringBuilder();
        }
        return result;
    }

    /**
     * 7ms Beats 5,67%, 41.71mb beats 35.97
     *
     * @param nums
     * @return
     */
    public List<String> summaryRanges2(int[] nums) {
        List<String> result = new ArrayList<>();
        String s = "";
        int j;
        int curr;
        for (int i = 0; i < nums.length; i++) {
            s += nums[i];
            j = i + 1;
            curr = nums[i];
            while (j < nums.length && curr + 1 == nums[j]) {
                curr = nums[j];
                j++;
            }
            if (curr != nums[i]) {
                s += "->" + curr;
            }
            i = j - 1;
            result.add(s);
            s = "";
        }
        return result;
    }

}
