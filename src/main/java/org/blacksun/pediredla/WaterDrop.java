package org.blacksun.pediredla;

/**
 * Created by Pediredla on 11/24/16.
 */
public class WaterDrop {
    public WaterDrop() {
    }

    public int solution(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int secHeight = 0;
        int area = 0;

        while (left < right) {
            if (height[left] < height[right]) {
                secHeight = Math.max(secHeight, height[left]);
                area += secHeight - height[left];
                ++left;
            } else {
                secHeight = Math.max(secHeight, height[right]);
                area += secHeight - height[right];
                --right;
            }
        }

        return area;
    }
}

