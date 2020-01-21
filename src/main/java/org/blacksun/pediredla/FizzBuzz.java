package org.blacksun.pediredla;

/**
 * Created by Pediredla on 11/24/16.
 */

import java.util.ArrayList;
import java.util.List;

public class FizzBuzz {
    public FizzBuzz() {
    }

    public List<String> fizzBuzz(int n) {
        ArrayList list = new ArrayList();

        for (int i = 1; i <= n; ++i) {
            String a = i % 3 == 0 && i % 5 == 0 ? "FizzBuzz" : (i % 5 == 0 ? "Buzz" : (i % 3 == 0 ? "Fizz" : String.valueOf(i)));
            list.add(a);
        }

        return list;
    }
}
