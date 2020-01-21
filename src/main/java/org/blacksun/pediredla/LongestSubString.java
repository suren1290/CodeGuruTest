package org.blacksun.pediredla;

/**
 * Created by Pediredla on 11/24/16.
 */

import java.util.HashMap;

public class LongestSubString {
    public LongestSubString() {
    }

    public int lengthOfLongestSubstring(String s) {
        if (s != null) {
            int right = this.containsDuplicates(s) ? this.lengthOfLongestSubstring(s.substring(0, s.length() - 1)) : s.length();
            int left = this.containsDuplicates(s) ? this.lengthOfLongestSubstring(s.substring(1, s.length())) : s.length();
            return left > right ? left : right;
        } else {
            return 0;
        }
    }

    private boolean containsDuplicates(String s) {
        HashMap book = new HashMap();

        for (int i = 0; i < s.length(); ++i) {
            Integer integer = (Integer) book.get(Character.valueOf(s.charAt(i)));
            if (integer != null) {
                return true;
            }

            book.put(Character.valueOf(s.charAt(i)), Integer.valueOf(1));
        }

        return false;
    }
}
