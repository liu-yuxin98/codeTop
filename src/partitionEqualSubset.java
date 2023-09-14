import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Map;

public class partitionEqualSubset {
    public boolean canPartition(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        Arrays.sort(nums);
        if(sum%2==1){
            return false;
        }
        int[][] dp = new int[nums.length][sum/2+1];

    }

    public static void main(String[] args) {
        int [] nums = {1,2,5};
        partitionEqualSubset sol = new partitionEqualSubset();
        sol.canPartition(nums);
    }


}
