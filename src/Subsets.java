import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Subsets {

//    List<List<Integer>> res = new ArrayList<>();
//    LinkedList<Integer> path = new LinkedList<>();
//
//    public List<List<Integer>> subsets(int[] nums) {
//        backtrack(nums,0);
//        return res;
//    }
//
//    public void backtrack(int[] nums, int startIndex){
//        res.add(new ArrayList<>(path));
//        for(int i=startIndex;i<nums.length;i++){
//            path.add(nums[i]);
//            backtrack(nums,i+1);
//            path.removeLast();
//        }
//    }


    List<List<Integer>> result = new ArrayList<>();// 存放符合条件结果的集合
    LinkedList<Integer> path = new LinkedList<>();// 用来存放符合条件结果
    public List<List<Integer>> subsets(int[] nums) {
        subsetsHelper(nums, 0);
        return result;
    }

    private void subsetsHelper(int[] nums, int startIndex){
        result.add(new ArrayList<>(path));//「遍历这个树的时候，把所有节点都记录下来，就是要求的子集集合」。
        for (int i = startIndex; i < nums.length; i++){
            path.add(nums[i]);
            subsetsHelper(nums, i + 1);
            path.removeLast();
        }
    }
    public static void main(String[] args) {
        Subsets sol = new Subsets();
        int[] nums = {1,2,3};
        sol.subsets(nums);
        System.out.println(sol.result);
    }
}
