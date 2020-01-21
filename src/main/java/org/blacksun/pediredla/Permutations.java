package org.blacksun.pediredla;

/**
 * Created by Pediredla on 11/24/16.
 */

import java.util.ArrayList;
import java.util.List;

public class Permutations {
    public Permutations() {
    }

    public List<List<Integer>> numberPermutation(int[] nums) {
        ArrayList result = new ArrayList();
        this.permute(result, nums, 0);
        return result;
    }

    private void permute(List<List<Integer>> result, int[] nums, int start) {
        if (nums.length != 0 && nums != null) {
            if (start >= nums.length) {
                List<Integer> temp = new ArrayList();
                int[] t = nums;
                int len = nums.length;

                for (int i = 0; i < len; ++i) {
                    int x = t[i];
                    temp.add(Integer.valueOf(x));
                }

                result.add(temp);
            } else {
                for (int i = start; i < nums.length; ++i) {
                    this.swap(nums, i, start);
                    this.permute(result, nums, start + 1);
                    this.swap(nums, i, start);
                }
            }

        }
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public List<String> stringPermuatation(String s) {
        ArrayList result = new ArrayList();
        this.permute(result, s, 0);
        return result;
    }

    private void permute(List<String> result, String s, int start) {
        if (s != null && s.length() != 0) {
            if (start >= s.length()) {
                result.add(s);
            } else {
                char[] letters = s.toCharArray();

                for (int i = start; i < s.length(); ++i) {
                    this.swap(letters, i, start);
                    StringBuilder sb = new StringBuilder();
                    sb.append(letters);
                    s = sb.toString();
                    this.permute(result, s, start + 1);
                    this.swap(letters, i, start);
                }
            }

        }
    }

    private void swap(char[] s, int i, int j) {
        char temp = s[i];
        s[i] = s[j];
        s[j] = temp;
    }
}

