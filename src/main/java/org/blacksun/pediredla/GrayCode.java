package org.blacksun.pediredla;

/**
 * Created by Pediredla on 11/24/16.
 */

import java.util.LinkedList;
import java.util.List;

public class GrayCode {
    public GrayCode() {
    }

    public List<Integer> grayCode(int n) {
        LinkedList result = new LinkedList();

        for (int i = 0; i < 1 << n; ++i) {
            System.out.println(1 << n);
            result.add(Integer.valueOf(i ^ i >> 1));
        }

        return result;
    }
}
