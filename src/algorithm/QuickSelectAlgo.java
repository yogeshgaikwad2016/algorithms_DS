package algorithm;

import java.util.Scanner;

public class QuickSelectAlgo {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter n and k:");
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int[] nums = new int[n];

        System.out.println("Enter " + n + " elements:");
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }

        int result = quickSelect(nums, 0, nums.length - 1, k - 1);
        System.out.println("The " + k + "-th smallest element is: " + result);
    }

    private static int quickSelect(int[] arr, int low, int high, int k) {
        if (low == high) {
            return arr[low];
        }

        int pivotIndex = partition(arr, low, high);

        if (k == pivotIndex) {
            return arr[k];
        } else if (k < pivotIndex) {
            return quickSelect(arr, low, pivotIndex - 1, k);
        } else {
            return quickSelect(arr, pivotIndex + 1, high, k);
        }
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low;

        while (low < high) {
            if (arr[low] > pivot) { // make > to find the largest number
                swap(arr, i, low);
                i++;
            }
            low++;
        }
        swap(arr, i, high);

        return i;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
