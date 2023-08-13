import java.util.HashMap;

public class kRepettionLongestSubString {

    public int lengthOfLongestSubstring(String s){
        return lengthOfLongestSubstringWithRrepetition(s,1);
    }

    public int lengthOfLongestSubstringWithRrepetition(String s, int k) {
        HashMap<Character, Integer> map = new HashMap<>();
        int maxLength = 0;
        int front = 0;
        int end = 0;
        while (end < s.length()) {
            if (!map.containsKey(s.charAt(end))) {
                map.put(s.charAt(end), 1);
                end += 1;
                continue;
            } else {
                map.put(s.charAt(end), map.get(s.charAt(end)) + 1);
            }
            if (map.get(s.charAt(end)) > k) {
                maxLength = Math.max(maxLength, end - front);
                // move front forward
                while (true) {
                    if (s.charAt(front) == s.charAt(end)) {
                        map.put(s.charAt(end), map.get(s.charAt(end)) - 1);
                        front+= 1;
                        break;
                    }
                    map.put(s.charAt(front), map.get(s.charAt(front)) - 1);
                    front += 1;
                }
            }
            // move end forward
            end += 1;
        }
        maxLength = Math.max(maxLength, s.length() - front);
        return maxLength;
    }

    public static void main(String[] args) {
        String s = "abcabcbb";
        kRepettionLongestSubString sol = new kRepettionLongestSubString();
        System.out.println(sol.lengthOfLongestSubstring(s));

    }


}
