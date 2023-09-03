import java.util.HashSet;
import java.util.Set;

public class LongestConse {

    public int longestConsecutive(int[] nums) {

        Set<Integer> sets =new HashSet<>();
        for(int n:nums){
            sets.add(n);
        }
        int maxL = 0;
        for(int n: nums){
            int curMax = 1;
            sets.remove(n);
            // smaller
            int small = n-1;
            while(sets.contains(small)){
                curMax++;
                sets.remove(small);
                small--;
            }
            // bigger
            int big = n+1;
            while(sets.contains(big)){
                curMax++;
                sets.remove(big);
                big ++;
            }
            maxL = Math.max(maxL,curMax);
        }
        return maxL;

    }
}
