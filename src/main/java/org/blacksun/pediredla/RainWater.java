package org.blacksun.pediredla;

/**
 * Created by Pediredla on 11/24/16.
 */
public class RainWater {
    public RainWater() {
    }

    public int trap(int[] height) {
        int result = 0;
        if (height != null && height.length > 2) {
            int[] left = new int[height.length];
            int[] right = new int[height.length];
            int max = height[0];
            left[0] = height[0];

            int i;
            for (i = 1; i < height.length; ++i) {
                if (height[i] < max) {
                    left[i] = max;
                } else {
                    left[i] = height[i];
                    max = height[i];
                }
            }

            max = height[height.length - 1];
            right[height.length - 1] = height[height.length - 1];

            for (i = height.length - 2; i >= 0; --i) {
                if (height[i] < max) {
                    right[i] = max;
                } else {
                    right[i] = height[i];
                    max = height[i];
                }
            }

            for (i = 0; i < height.length; ++i) {
                result += Math.min(left[i], right[i]) - height[i];
            }

            for (i = 0; i < height.length; ++i) {
                System.out.print(right[i] - height[i]);
            }

            return result;
        } else {
            return result;
        }
    }

    public String countAndSay(int n) {
        if (n <= 0) {
            return null;
        } else {
            String result = "1";

            for (int i = 1; i < n; ++i) {
                StringBuilder sb = new StringBuilder();
                int count = 1;

                for (int j = 1; j < result.length(); ++j) {
                    if (result.charAt(j) == result.charAt(j - 1)) {
                        ++count;
                    } else {
                        sb.append(count);
                        sb.append(result.charAt(j - 1));
                        count = 1;
                    }
                }

                sb.append(count);
                sb.append(result.charAt(result.length() - 1));
                result = sb.toString();
            }

            return result;
        }
    }
}

