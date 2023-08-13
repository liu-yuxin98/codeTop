import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Combination77 {


    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
            backtrack(new ArrayList<>(),k,1,n+1);
            return res;
    }

    public void backtrack(List<Integer> current, int k,int cur, int n){
        if(current.size()==k){
            res.add(new ArrayList<>(current));
            return;
        }
        for(int i=cur;i<n;i++){
            if(!current.contains(i)){
                current.add(i);
            }
            backtrack(current,k,i+1,n);
            current.remove(current.size()-1);
        }

    }


    public static void main(String[] args) {
        Combination77 sol = new Combination77();
        List<List<Integer>> res  = sol.combine(4,2);
        System.out.println(res);
    }
}
