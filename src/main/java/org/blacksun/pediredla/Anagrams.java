package org.blacksun.pediredla;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Anagrams {
    private int somenumber;

    public Anagrams() {
    }

    public List<Integer> findAnagrams(String s, String p) {
        ArrayList answer = new ArrayList();
        this.fill(answer, s, p, 0, p.length());
        return answer;
    }

    private void fill(List<Integer> answer, String s, String p, int start, int size) {
        if (start + size <= s.length() && s.length() >= 1 && p.length() >= 1 && s != null && p != null) {
            if (this.isValid(p, s.substring(start, start + size))) {
                answer.add(Integer.valueOf(start));
            }

            this.fill(answer, s, p, start + 1, size);
        }
    }

    public boolean isValid(String s, String t) {
        int[] alphabet = new int[26];

        int i;
        for (i = 0; i < s.length(); ++i) {
            ++alphabet[s.charAt(i) - 97];
        }

        for (i = 0; i < t.length(); ++i) {
            --alphabet[t.charAt(i) - 97];
        }

        int[] var8 = alphabet;
        int var5 = alphabet.length;

        for (int var6 = 0; var6 < var5; ++var6) {
            int i1 = var8[var6];
            if (i1 != 0) {
                return false;
            }
        }

        return true;
    }

    public void generate(Set<String> book, int index, char[] word) {
        if (word != null && word.length >= 1) {
            if (index == word.length) {
                book.add(new String(word));
            } else {
                for (int i = 0; i < word.length; ++i) {
                    char temp = word[i];
                    word[i] = word[index];
                    word[index] = temp;
                    this.generate(book, index + 1, word);
                    temp = word[index];
                    word[index] = word[i];
                    word[i] = temp;
                }

            }
        }
    }
}
