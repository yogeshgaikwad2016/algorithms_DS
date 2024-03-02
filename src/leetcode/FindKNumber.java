package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class FindKNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }

        FindKNumber findKNumber = new FindKNumber();
        findKNumber.findKthLargest(nums, k);
    }

    public int findKthLargest(int[] nums, int k) {
        if (k <= 0 || nums.length <= 0) return 0;

        List<String> max = new ArrayList<>(k);
        for (int i = 0; i < k; i++)
            max.add(String.valueOf(i));

        //int start = 1;
        for (int j = 0; j < max.size(); j++) {
            for (int i = j+1; i < nums.length; i++) {
                if (!max.contains(String.valueOf(i)) && nums[Integer.parseInt(max.get(j))] <= nums[i]) {
                    //shiftArr(max, nums[i]);
                    max.set(j, String.valueOf(i));
                }
            }
            System.out.println("max = " + max);
        }

        return nums[Integer.parseInt(max.get(k - 1))];
    }

    private void shiftArr(int[] arr, int ele) {
        for(int i = 0; i < arr.length; i++) {
            int temp = arr[i];
            arr[i] = ele;
            ele = temp;
        }
    }
}
