package org.blacksun.pediredla;

/**
 * Created by Pediredla on 11/24/16.
 */

import java.util.*;

public class GFG {
    private static final String BLANK = " ";

    public GFG() {
    }

    private int factorial(int n) {
        return n > 1 ? n * this.factorial(n - 1) : 1;
    }

    private void permute(char a, int left, int right) {
    }

    public Map<Integer, String> combinations(String s) {
        HashMap book = new HashMap();
        if (s.equals(" ")) {
            return null;
        } else {
            ArrayList letters = new ArrayList(Arrays.asList(s.split("")));
            int count = 0;

            while (count < this.factorial(s.length())) {
                Collections.shuffle(letters);
                if (!book.containsValue(letters.toString())) {
                    book.put(Integer.valueOf(count), letters.toString());
                    ++count;
                }
            }

            return book;
        }
    }
}

