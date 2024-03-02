package other_programs;

import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(new Solution().kClosest(new int[][]{{1, 3}, {-2, 2}, {2, -2}}, 2)));
    }

    public int[][] kClosest(int[][] points, int k) {
        int[] result = new int[points.length];
        int[][] output = new int[k][2];
        int count = 0;
        for (int i = 0; i < points.length; i++) {
            result[count++] = Solution.euclideanAlgo(0, points[i][0], 0, points[i][1]);
            System.out.println("RS: " + Arrays.toString(result));
            if (count > 1 && result[count - 1] < result[count - 2]) {
                int tempCn = result[count - 1];
                result[count - 1] = result[count - 2];
                result[count - 2] = tempCn;

                int[] temp = {points[count - 1][0], points[count - 1][1]};
                points[count - 1][0] = points[count - 2][0];
                points[count - 1][1] = points[count - 2][1];

                points[count - 2][0] = temp[0];
                points[count - 2][1] = temp[1];
            }
            System.out.println("SHIFT: " + Arrays.deepToString(points));
        }

        for (int i = 0; i < k; i++) {
            output[i][0] = points[i][0];
            output[i][1] = points[i][1];
        }

        return output;
    }

    public static int euclideanAlgo(int x1, int x2, int y1, int y2) {
        return (int) Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
    }
}