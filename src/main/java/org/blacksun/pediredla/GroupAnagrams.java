package org.blacksun.pediredla;

/**
 * Created by Pediredla on 11/24/16.
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class GroupAnagrams {
    public GroupAnagrams() {
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        HashSet visited = new HashSet();
        ArrayList lib = new ArrayList();

        for (int i = 0; i < strs.length; ++i) {
            ArrayList anagram = new ArrayList();
            anagram.add(strs[i]);
            if (!visited.add(Integer.valueOf(i))) {
                lib.add(anagram);
            } else {
                for (int j = i + 1; j < strs.length; ++j) {
                    if (visited.add(Integer.valueOf(j)) && this.isAnagram(strs[i], strs[j])) {
                        anagram.add(strs[j]);
                    }
                }

                lib.add(anagram);
            }
        }

        return lib;
    }

    private boolean isAnagram(String s, String t) {
        if (s != null && t != null && s.length() == t.length()) {
            int[] arr = new int[26];

            for (int i = 0; i < s.length(); ++i) {
                ++arr[s.charAt(i) - 97];
                --arr[t.charAt(i) - 97];
            }

            int[] var8 = arr;
            int var5 = arr.length;

            for (int var6 = 0; var6 < var5; ++var6) {
                int i1 = var8[var6];
                if (i1 != 0) {
                    return false;
                }
            }

            return true;
        } else {
            return false;
        }
    }

    public boolean isAnagrams(String s, String t) {
        if (s != null && t != null && s.length() == t.length()) {
            HashMap map = new HashMap();

            int i;
            for (i = 0; i < s.length(); ++i) {
                if (map.containsKey(Character.valueOf(s.charAt(i)))) {
                    map.put(Character.valueOf(s.charAt(i)), Integer.valueOf(((Integer) map.get(Character.valueOf(s.charAt(i)))).intValue() + 1));
                } else {
                    map.put(Character.valueOf(s.charAt(i)), Integer.valueOf(1));
                }
            }

            for (i = 0; i < t.length(); ++i) {
                if (!map.containsKey(Character.valueOf(t.charAt(i)))) {
                    return false;
                }

                if (((Integer) map.get(Character.valueOf(t.charAt(i)))).intValue() <= 0) {
                    return false;
                }

                map.put(Character.valueOf(t.charAt(i)), Integer.valueOf(((Integer) map.get(Character.valueOf(t.charAt(i)))).intValue() - 1));
            }

            return map.size() <= 0;
        } else {
            return false;
        }
    }
}

