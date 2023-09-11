import java.util.ArrayList;
import java.util.List;

public class RestoreIP {


    List<String> res = new ArrayList<>();

    List<String> path = new ArrayList<>();
    public List<String> restoreIpAddresses(String s) {
        backtrack(1,s,0);
        return res;
    }

    public void backtrack(int start, String s, int layer){
        // impossible string s
        if(s.length()<4 || s.length()>12){
            return;
        }
        // impossible for rest to fit
        if( layer<5 && (s.length()-start)/(5-layer)>3 ){
            return;
        }

        if(layer==5){
            String address = String.join(".",path);
            if(address.length()==s.length()+3){
                res.add(address);
            }
            return;
        }
        for(int i=start;i<Math.min(start+3,s.length());i++){
            String digits = s.substring(start,i+1);
            Integer value = Integer.parseInt(digits);
            // make sure no leading 0
            if(String.valueOf(value).length()==digits.length()){
                // make sure [0,255]
                if(value>=0 && value<=255){
                    path.add(digits);
                    backtrack(i+1,s,i+1);
                    path.remove(path.size()-1);
                }
            }
        }

    }



}
