import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class BasicCalculator224 {
    public int calculate(String s) {

        Stack<String> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                Integer tempSum = stackBack(stack);
                stack.push(tempSum.toString());
            } else {
                Character c = s.charAt(i);
                if (c != ' ') {
                    stack.push(c.toString());
                }
            }
        }
        int res = stackBack(stack);
        return res;
    }

    public Integer stackBack(Stack<String> stack) {
        Set<String> digits = new HashSet<>();
        digits.add("0");
        digits.add("1");
        digits.add("2");
        digits.add("3");
        digits.add("4");
        digits.add("5");
        digits.add("6");
        digits.add("7");
        digits.add("8");
        digits.add("9");
        int tempSum = 0;
        while (stack.size() > 0) {
            String numS = stack.pop();
            if (numS.equals("(") || numS.equals("+") || numS.equals("-")) {
                break;
            }
            int num = Integer.parseInt(numS);
            int digit = 0;
            while (stack.size() > 0 && digits.contains(stack.peek())) {
                int curDigit = Integer.parseInt(stack.pop());
                digit += 1;
                num = curDigit * (int) Math.pow(10, digit) + num;
            }

            if (stack.size() == 0) {
                tempSum += num;
                break;
            } else {
                String opt = stack.pop();
                if (opt.equals("-")) {
                    tempSum -= num;
                } else if (opt.equals("+")) {
                    tempSum += num;
                } else if (opt.equals("(")) {
                    tempSum += num;
                    break;
                }

            }
        }
        return tempSum;
    }

    public static void main(String[] args) {
        String s = "(1+(4+5+2)-3)+(6+8)";
        BasicCalculator224 sol = new BasicCalculator224();
        System.out.println(sol.calculate(s));

    }

}
