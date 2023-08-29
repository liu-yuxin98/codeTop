import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.PriorityQueue;

public class MaxSumOfArrayAfterKNegations {
    public int largestSumAfterKNegations(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int n:nums){
            pq.add(n);
        }
        while(k>0){
            pq.add(-pq.poll());
            k--;
        }
        int sum = 0;
        while(!pq.isEmpty()){
            sum += pq.poll();
        }
        return sum;
//
//        Arrays.sort(nums);
//        int i =0;
//        while(k>0 && i<nums.length){
//            if(nums[i]<0){
//                nums[i] = -nums[i];
//            }else if(nums[i]==0){
//                return  Arrays.stream(nums).sum();
//            }else{
//                if(k%2==0){
//                    return  Arrays.stream(nums).sum();
//                }else{
//                    Arrays.sort(nums);
//                    nums[0] = -nums[0];
//                }
//            }
//            i++;
//            k--;
//        }
//        if(k>0){
//            if(k%2!=0){
//                Arrays.sort(nums);
//                nums[0] = -nums[0];
//            }
//        }
//
//        return  Arrays.stream(nums).sum();

    }
}
