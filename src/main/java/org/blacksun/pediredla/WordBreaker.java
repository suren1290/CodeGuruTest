package org.blacksun.pediredla;

/**
 * Created by Pediredla on 11/24/16.
 */

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class WordBreaker {
    public WordBreaker() {
    }

    public boolean wordBreak(String s, Set<String> wordDict) {
        if (wordDict.size() <= 0) {
            return false;
        } else {
            StringBuilder sb = new StringBuilder();
            HashSet match = new HashSet();
            boolean flag = false;
            Iterator i = wordDict.iterator();

            while (i.hasNext()) {
                String word = (String) i.next();
                flag = s.contains(word);
                if (flag) {
                    break;
                }
            }

            if (!flag) {
                return flag;
            } else {
                for (; flag; flag = !sb.toString().equals("")) {
                    for (int var8 = 0; var8 < s.length(); ++var8) {
                        sb.append(s.charAt(var8));
                        if (wordDict.contains(sb.toString()) && match.add(sb.toString())) {
                            sb = new StringBuilder();
                        }
                    }

                    if (match.contains(sb.toString())) {
                        sb = new StringBuilder();
                    }
                }

                return sb.toString().equals("");
            }
        }
    }
}

