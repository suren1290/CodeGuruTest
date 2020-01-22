package org.blacksun.pediredla;

/**
 * Created by Pediredla on 11/24/16.
 */

import java.util.HashMap;

public class TwoSum {
    public TwoSum() {
    }

    public int[] twoSum(int[] nums, int target) {
        int[] ans = new int[2];
        HashMap book = new HashMap();

        for (int i = 0; i < nums.length; ++i) {
            book.put(Integer.valueOf(nums[i]), Integer.valueOf(i));
            if (book.containsKey(Integer.valueOf(target - nums[i]))) {
                ans[0] = ((Integer) book.get(Integer.valueOf(target - nums[i]))).intValue();
                ans[1] = i;
                return ans;
            }
        }

        return ans;
    }
}
