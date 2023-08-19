import java.util.ArrayList;
import java.util.List;

public class permutations {

    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();


    private void backtrack(int [] nums){
        if(path.size()==nums.length){
            res.add(new ArrayList<>(path));
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(path.contains(nums[i])){
                continue;
            }
            path.add(nums[i]);
            backtrack(nums);
            path.remove(path.size()-1);
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        backtrack(nums);
        return res;
    }


}
