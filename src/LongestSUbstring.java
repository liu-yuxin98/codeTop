import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestSUbstring {

    public int lengthOfLongestSubstring(String s) {

        Set<Character> chars = new HashSet<>();
        int front =0;
        int end = 0;
        int maxL = 0;
        while(end<s.length()){
            if(chars.contains(s.charAt(end))){
                maxL = Math.max(maxL, end-front);
                //move front forward
                while(true){
                    if(s.charAt(front)==s.charAt(end)){
                        front ++;
                        break;
                    }   else{
                        chars.remove(s.charAt(front));
                        front++;
                    }
                }
            }else{
                chars.add(s.charAt(end));
            }
            end ++;
        }
        maxL = Math.max(maxL,end-front);
        return  maxL;
    }
}
