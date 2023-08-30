import java.util.Arrays;

public class MaxRectangle {

    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        // how many '1' in the left(including current pos) of current pos(i,j)
        int[][] leftOne = leftContinueOne(matrix);
        int max = 0;
        System.out.println(Arrays.deepToString(leftOne));
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                // for each pos we calculate the max rectangle whose right bottom corner is (i,j)
                max = Math.max(max, findMaxRectangleFromPos(matrix, leftOne, i, j));
            }
        }
        return max;
    }


    public int[][] leftContinueOne(char[][] matrix) {
        // calculate how many continue '1' in left of current pos in current row, including current pos
        int[][] leftOne = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][0] == '1') {
                leftOne[i][0] = 1;
            } else {
                leftOne[i][0] = 0;
            }
            for (int j = 1; j < matrix[i].length; j++) {
                if (matrix[i][j] == '0') {
                    leftOne[i][j] = 0;
                } else {
                    leftOne[i][j] = leftOne[i][j - 1] + 1;
                }
            }
        }
        return leftOne;
    }


    public int findMaxRectangleFromPos(char[][] matrix, int[][] leftOne, int i, int j) {
        // to find the largest rectangle with [i,j] as right bottom corner.
        if (matrix[i][j] == '0') {
            return 0;
        }
        int w = leftOne[i][j];
        int max = w;
        int k = i - 1;
        int h = i - k + 1;
        while (k >= 0) {
            w = Math.min(leftOne[k][j], w);
            max = Math.max(max, h * w);
            k--;
            h++;
        }
        return max;
    }

}
