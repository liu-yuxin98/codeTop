import java.util.Deque;
import java.util.LinkedList;

public class DecordingString {

    public String decodeString(String s) {

        Deque<Character> deque = new LinkedList<>();
        for(Character c: s.toCharArray()){
            deque.offer(c);
        }
        System.out.println(deque);
        return helper(deque);
    }

    public static String helper(Deque<Character> deque){
        if(deque.isEmpty()){
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int num =0;
        while(!deque.isEmpty()){
            char c = deque.pop();
            if(Character.isDigit(c)){
                num = num*10+c-'0';
            }else if(c=='['){
                String sub = helper(deque);
                for (int i=0;i<num;i++){
                    sb.append(sub);
                }
                num = 0;
            } else if(c==']'){
                break;
            }else{
                sb.append(c);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        DecordingString sol = new DecordingString();
        String s = "3[a]2[bc]";
        System.out.println(sol.decodeString(s));

    }


}
