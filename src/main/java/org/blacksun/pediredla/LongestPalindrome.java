package org.blacksun.pediredla;

/**
 * Created by Pediredla on 11/24/16.
 */

import java.util.HashMap;
import java.util.Iterator;

public class LongestPalindrome {
    public LongestPalindrome() {
    }

    public String longestPalindrome(String s) {
        HashMap book = new HashMap();
        if (s.equals("") && s == null) {
            return null;
        } else if (this.isPalindrome(s)) {
            return s;
        } else {
            String p;
            for (int longestSubString = 0; longestSubString < s.length(); ++longestSubString) {
                for (int j = s.length() - 1; j > longestSubString; --j) {
                    p = (new StringBuilder(s.substring(longestSubString, j))).reverse().toString();
                    book.put(s.substring(longestSubString, j), p);
                }
            }

            String var6 = null;
            Iterator var7 = book.keySet().iterator();

            while (var7.hasNext()) {
                p = (String) var7.next();
                if (book.containsValue((new StringBuilder(p)).reverse().toString())) {
                    var6 = s;
                }
            }

            return var6;
        }
    }

    private boolean isPalindrome(String s) {
        if (!s.equals("")) {
            String reverse = (new StringBuilder(s)).reverse().toString();
            if (s.equals(reverse)) {
                return true;
            }
        }

        return false;
    }
}

