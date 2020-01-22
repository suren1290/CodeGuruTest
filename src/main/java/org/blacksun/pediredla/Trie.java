package org.blacksun.pediredla;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * Created by Pediredla on 1/14/17.
 */
public class Trie {
    private List<String> words = new ArrayList<String>();

    public Trie(Collection<String> words) {
        this.words.addAll(words);
        Collections.sort(this.words);
    }

    public boolean contains(String word) {
        int pos = Collections.binarySearch(words, word);
        return pos>=0;
    }

    public boolean addWord(String word) {
        int pos = Collections.binarySearch(words, word);
        if(pos<0) {
            words.add(-(pos+1), word);
            return true;
        }
        return false;
    }

    public boolean isPrefix(String prefix) {
        int pos = Collections.binarySearch(words, prefix);
        if(pos>=0) {
            if(pos+1<words.size()) {
                String nextWord = words.get(pos+1);
                return nextWord.startsWith(prefix);
            }
            return false;
        }
        pos = -(pos+1);
        if(pos == words.size()) {
            return false;
        }
        String nextWord = words.get(pos);
        return nextWord.startsWith(prefix);
    }
}
