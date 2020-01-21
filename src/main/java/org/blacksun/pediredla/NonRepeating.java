package org.blacksun.pediredla;

/**
 * Created by Pediredla on 11/24/16.
 */
public class NonRepeating {
    public NonRepeating() {
    }

    public int firstUniqChar(String s) {
        int[] freq = new int[26];

        int i;
        for (i = 0; i < s.length(); ++i) {
            ++freq[s.charAt(i) - 97];
        }

        for (i = 0; i < s.length(); ++i) {
            if (freq[s.charAt(i) - 97] == 1) {
                return i;
            }
        }

        return -1;
    }
}