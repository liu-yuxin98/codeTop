import java.util.Deque;
import java.util.LinkedList;
import java.util.Map;
import java.util.Stack;

public class longestValidParentheses {
    public int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        stack.add(-1);
        int max = 0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i) =='('){
                stack.push(i);
            }else{
                stack.pop();
                if(stack.isEmpty()){
                    stack.push(i);
                }else{
                    max = Math.max(i-stack.peek(), max);
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        longestValidParentheses sol  = new longestValidParentheses();
        String s = "()(()";
        System.out.println(sol.longestValidParentheses(s));
    }

}
