package org.blacksun.pediredla;

/**
 * Created by Pediredla on 11/24/16.
 */

import java.util.LinkedList;
import java.util.Set;

public class Wordladder {
    public Wordladder() {
    }

    public int solution(String start, String end, Set<String> dict) {
        LinkedList queue = new LinkedList();
        queue.add(start);
        int count = 0;

        while (!queue.isEmpty()) {
            String word = (String) queue.poll();
            if (word != null) {
                if (word.equals(end)) {
                    break;
                }

                char[] letters = word.toCharArray();

                for (int i = 0; i < letters.length; ++i) {
                    for (char c = 97; c <= 122; ++c) {
                        char temp = letters[i];
                        if (c != temp) {
                            letters[i] = c;
                            String check = new String(letters);
                            if (dict.contains(check)) {
                                queue.add(check);
                                dict.remove(check);
                                ++count;
                            } else {
                                letters[i] = temp;
                            }
                        }
                    }
                }
            }
        }

        return count;
    }
}

