import java.util.HashMap;
import java.util.Map;

public class SubSumK {

    public int subarraySum(int[] nums, int k) {
        if(nums.length==0){
            return 0;
        }
        int [] preSum = new int[nums.length];
        preSum[0] = nums[0];
        for(int i=1;i<nums.length;i++){
            preSum[i] = preSum[i-1]+nums[i];
        }
        Map<Integer,Integer> map = new HashMap<>();
        int cnt =0 ;
        for(int i=0;i<nums.length;i++){
            if(preSum[i]==k){
                cnt++;
            }
            if(map.containsKey(preSum[i]-k) ){
                cnt += map.get(preSum[i]-k);
            }
            map.put(preSum[i], map.getOrDefault(preSum[i],0)+1);
        }
        return cnt;

    }


    public static void main(String[] args) {
        SubSumK sol = new SubSumK();
        int[] nums = new int[]{-1,-1,1};
        int k = 0;
        System.out.println(sol.subarraySum(nums,k));

    }
}
