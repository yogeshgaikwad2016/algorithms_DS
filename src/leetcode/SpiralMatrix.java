package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SpiralMatrix {

    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        if (matrix == null || matrix.length == 0) {
            return result;
        }

        int eleHT = 0;
        int eleVB = matrix[0].length - 1;
        int eleHB = matrix.length - 1;
        int eleVT = 0;

        while (eleHT <= eleHB && eleVT <= eleVB) {
            moveForward(result, matrix, eleVB, eleHT);
            eleHT++;

            moveTopToBottom(result, matrix, eleHT, eleHB, eleVB);
            eleVB--;

            if (eleHT <= eleHB) {
                moveBackward(result, matrix, eleVB, eleHB, eleVT);
                eleHB--;
            }

            if (eleVT <= eleVB) {
                moveBottomUp(result, matrix, eleHB, eleHT, eleVT);
                eleVT++;
            }
        }
        return result;
    }

    public static void moveForward(List result, int[][] matrix, int count, int eleH) {
        for (int i = eleH; i <= count; i++) {
            result.add(matrix[eleH][i]);
        }
    }

    public static void moveTopToBottom(List result, int[][] matrix, int start, int eleVB, int right) {
        for (int i = start; i <= eleVB; i++) {
            result.add(matrix[i][right]);
        }
    }

    public static void moveBottomUp(List result, int[][] matrix, int start, int eleVT, int left) {
        for (int i = start; i >= eleVT; i--) {
            result.add(matrix[i][left]);
        }
    }

    public static void moveBackward(List result, int[][] matrix, int end, int eleHB, int eleVt) {
        for (int i = end; i >= eleVt; i--) {
            result.add(matrix[eleHB][i]);
        }
    }
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        System.out.println("Read N & M: ");
        int n = read.nextInt(), m = read.nextInt();
        int[][] matrix = new int[n][m];

        System.out.println("Read Array: ");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                matrix[i][j] = read.nextInt();
            }
        }
        //System.out.println("MATRIX: " + matrix);

        System.out.println("RESULT:" + spiralOrder(matrix));
    }
}
