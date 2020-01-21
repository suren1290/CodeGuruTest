package org.blacksun.pediredla;

/**
 * Created by Pediredla on 11/24/16.
 */

import java.util.ArrayList;
import java.util.Collections;

public class MaxRotateFunction {
    public MaxRotateFunction() {
    }

    public int maxRotateFunction(int[] A) {
        boolean value = false;
        int count = 0;

        ArrayList sums;
        for (sums = new ArrayList(); count < A.length; ++count) {
            int var7 = 0;

            int i;
            for (i = 0; i < A.length; ++i) {
                var7 += i * A[i];
            }

            sums.add(Integer.valueOf(var7));

            for (i = 0; i < A.length; ++i) {
                int temp = A[i];
                A[i] = A[A.length - 1];
                A[A.length - 1] = temp;
            }
        }

        if (!sums.isEmpty()) {
            Collections.sort(sums);
            return ((Integer) sums.get(sums.size() - 1)).intValue();
        } else {
            return 0;
        }
    }

    public int optimized(int[] A) {
        int F = 0;
        int sum = 0;
        int res = -2147483648;
        int n = A.length;
        if (n <= 1) {
            return 0;
        } else {
            int k;
            for (k = 0; k < n; ++k) {
                F += k * A[k];
                sum += A[k];
            }

            if (F > res) {
                res = F;
            }

            for (k = 1; k < n; ++k) {
                F += sum;
                F -= n * A[n - k];
                if (F > res) {
                    res = F;
                }
            }

            return res;
        }
    }
}

