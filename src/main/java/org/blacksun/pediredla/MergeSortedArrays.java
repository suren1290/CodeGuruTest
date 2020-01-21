package org.blacksun.pediredla;

/**
 * Created by Pediredla on 1/3/17.
 */
public class MergeSortedArrays {
    public static void mergeArrays(int[] arr1, int m, int[] arr2, int n) {
        while (m > 0 && n > 0) {
            if (arr1[m - 1] > arr2[n - 1]) {
                arr1[m + n - 1] = arr1[m - 1];
                m--;
            } else {
                arr1[m + n - 1] = arr2[n - 1];
                n--;
            }
        }
        while (n > 0) {
            arr1[m + n - 1] = arr2[n - 1];
            n--;
        }
    }
}
