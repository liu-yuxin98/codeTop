import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class MaxSubarray {
    public int maxSubArray(int[] nums) {
        // dp[i] = max(dp[i],0)+nums[i]
        //dp[i], largest sum end with dp[i]
        Integer [] dp = new Integer[nums.length];
        dp[0] = nums[0];
        for(int i=1;i<nums.length;i++){
            dp[i] = Math.max(0,dp[i-1])+nums[i];
        }
        return Collections.max(Arrays.asList(dp));
    }
}
