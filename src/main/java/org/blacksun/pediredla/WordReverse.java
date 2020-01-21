package org.blacksun.pediredla;

/**
 * Created by Pediredla on 11/24/16.
 */
public class WordReverse {
    public void wordReverse(char[] sen) {
        int s = 0;

        for (int i = 0; i < sen.length; ++i) {
            if (sen[i] == 32) {
                this.reverse(sen, s, i - 1);
                s = i + 1;
            }
        }

        this.reverse(sen, s, sen.length - 1);
        this.reverse(sen, 0, sen.length - 1);
    }

    public void reverse(char[] arr, int i, int j) {
        while (i < j) {
            char temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            ++i;
            --j;
        }

    }
}
