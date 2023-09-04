import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;

public class MinNumberArrows {


    public int findMinArrowShots(int[][] points) {

        Arrays.sort(points, Comparator.comparing(o -> o[0]));
        int cnt = 1;
        for (int i = 1; i < points.length; i++) {
            if (points[i - 1][1] < points[i][0]) {
                cnt++;
            } else {
                points[i][1] = Math.min(points[i - 1][1], points[i][1]);
            }
        }
        return cnt;
    }


    public static void main(String[] args) {
        MinNumberArrows sol = new MinNumberArrows();
        int[][] points = new int[][]{{10, 16}, {2, 8}, {1, 6}, {7, 12}};
        sol.findMinArrowShots(points);
    }


}



