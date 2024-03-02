package leetcode;

import static java.lang.Math.max;
import static java.lang.Math.min;

public class LeetCodeTest {

    public static void main(String[] args) {
        int[] height = new int[]{0,1,0,2,1,0,1,3,2,1,2,1};
        int result = new LeetCodeTest().trap2(height);
        System.out.println(result);
    }


    public static int trap(int[] height) {
        int i = 0;
        int j = 1;
        int result = 0;
        int len = height.length;
        int substractor = 0;
        int multiplier = 0;

        while (len - 2 > i) {
            int tempRes = height[i];
            if (j >= len) {
                height[i] = tempRes - 1;
                j = i + 1;
                substractor = 0;
                multiplier = 0;
                continue;
            }
            if (tempRes == 0) {
                i++;
            } else if (tempRes > height[j]) {
                multiplier++;
                substractor += height[j];
            } else if (tempRes <= height[j]) {
                result += (tempRes * multiplier - substractor);
                substractor = 0;
                multiplier = 0;
                i = j;
            }
            j++;
        }
        return result;
    }


    int trap2(int[] height)
    {
        if(height.length <= 0)
            return 0;
        int ans = 0;
        int size = height.length;
        int[] left_max = new int[size];
        int[] right_max = new int[size];

        left_max[0] = height[0];

        for (int i = 1; i < size; i++) {
            left_max[i] = max(height[i], left_max[i - 1]);
        }
        right_max[size - 1] = height[size - 1];
        for (int i = size - 2; i > 0; --i) {
            right_max[i] = max(height[i], right_max[i + 1]);
        }
        for (int i = 1; i < size - 1; i++) {
            ans += min(left_max[i], right_max[i]) - height[i];
        }
        return ans;
    }
}
