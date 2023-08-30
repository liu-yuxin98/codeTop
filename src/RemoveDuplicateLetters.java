import java.util.HashMap;

import java.util.Stack;

public class RemoveDuplicateLetters {
    public String removeDuplicateLetters(String s) {
        // 单调栈
        Stack<Character> stack = new Stack<>();
        HashMap<Character, Integer> charNums = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            charNums.put(s.charAt(i), charNums.getOrDefault(s.charAt(i), 0) + 1);
        }

        for (int i = 0; i < s.length(); i++) {
            if (stack.contains(s.charAt(i))) {
                charNums.put(s.charAt(i), charNums.get(s.charAt(i)) - 1);
                continue;
            }
            while (!stack.isEmpty() && stack.peek() >= s.charAt(i) && charNums.get(stack.peek()) > 0) {
                stack.pop();
            }
            stack.push(s.charAt(i));
            charNums.put(s.charAt(i), charNums.get(s.charAt(i)) - 1);
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        sb.reverse();
        return sb.toString();
    }
}
