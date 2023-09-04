import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GenerateP {

    public List<String> generateParenthesis(int n) {
        return helper(n);
    }

    public static List<String> helper(int layer){
        if(layer==1){
            List<String> res = new ArrayList<>();
            res.add("()");
            return res;
        }
        List<String> parentheses = helper(layer-1);
        Set<String> resSet = new HashSet<>();
        List<String> resList ;
        for(String str:parentheses){
            for(int i=0;i<str.length();i++){
                String newP = str.substring(0,i)+"()"+str.substring(i,str.length());
                resSet.add(newP);
            }
        }
        resList = new ArrayList<>(resSet);
        return resList;
    }


    public static void main(String[] args) {
        GenerateP sol = new GenerateP();
        System.out.println(sol.generateParenthesis(1));
        System.out.println(sol.generateParenthesis(2));
        System.out.println(sol.generateParenthesis(3));
    }


}
