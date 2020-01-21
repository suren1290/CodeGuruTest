package org.blacksun.pediredla;

/**
 * Created by Pediredla on 11/24/16.
 */

import java.util.HashMap;
import java.util.Iterator;

public class MaxProfit {
    public MaxProfit() {
    }

    public int maxProfit(int[] prices) {
        if (prices.length > 1) {
            boolean diff = false;
            int allTimeLow = prices[0];
            HashMap counter = new HashMap();
            int[] max = prices;
            int var6 = prices.length;

            int key;
            for (key = 0; key < var6; ++key) {
                int price = max[key];
                if (price < allTimeLow) {
                    allTimeLow = price;
                }

                int var9 = price - allTimeLow;
                counter.put(Integer.valueOf(price), Integer.valueOf(var9));
            }

            int var10 = 0;
            Iterator var11 = counter.keySet().iterator();

            while (var11.hasNext()) {
                key = ((Integer) var11.next()).intValue();
                if (var10 < ((Integer) counter.get(Integer.valueOf(key))).intValue()) {
                    var10 = ((Integer) counter.get(Integer.valueOf(key))).intValue();
                }
            }

            return var10;
        } else {
            return 0;
        }
    }

    public int maxProfit(int[] prices, String s) {
        if (prices.length > 1) {
            int allTimeLow = 2147483647;
            int profit = 0;

            for (int i = 0; i < prices.length; ++i) {
                if (prices[i] < allTimeLow) {
                    allTimeLow = prices[i];
                } else if (prices[i] - allTimeLow > profit) {
                    profit = prices[i] - allTimeLow;
                }
            }

            return profit;
        } else {
            return 0;
        }
    }
}

