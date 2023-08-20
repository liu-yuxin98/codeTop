import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MinWindowSubstring {
    public String minWindow(String s, String t) {
        Map<Character, Integer> freqMap = new HashMap<>();
        Set<Character> lackSet = new HashSet<>();
        for (int i = 0; i < t.length(); i++) {
            if (freqMap.containsKey(t.charAt(i))) {
                freqMap.put(t.charAt(i), freqMap.get(t.charAt(i)) + 1);
            } else {
                freqMap.put(t.charAt(i), 1);
            }
            lackSet.add(t.charAt(i));
        }
        int[] shortest = new int[]{-1, -1};
        int front = 0;
        int end = 0;
        while (end < s.length()) {

            if (freqMap.containsKey(s.charAt(end))) {
                // update freqMap
                freqMap.put(s.charAt(end), freqMap.get(s.charAt(end)) - 1);
                if (freqMap.get(s.charAt(end)) <= 0) {
                    lackSet.remove(s.charAt(end));
                }
                while (lackSet.isEmpty()) {
                    //move front forward
                    if (freqMap.containsKey(s.charAt(front))) {
                        freqMap.put(s.charAt(front), freqMap.get(s.charAt(front)) + 1);
                        if (freqMap.get(s.charAt(front)) > 0) {
                            lackSet.add(s.charAt(front));
                            if (shortest[0] == -1) {
                                shortest[0] = front;
                                shortest[1] = end;
                            } else{
                                if((end-front)<(shortest[1]-shortest[0])){
                                    shortest[0] = front;
                                    shortest[1] = end;
                                }
                            }
                            front += 1;
                            break;
                        }
                    }
                    front += 1;
                }
            }
            end += 1;
        }

        if (shortest[0] == -1) {
            return "";
        } else {
            return s.substring(shortest[0], shortest[1] + 1);
        }

    }

    public static void main(String[] args) {
        MinWindowSubstring sol = new MinWindowSubstring();
        String s = "cabwefgewcwaefgcf";
        String t = "cae";
        String res = sol.minWindow(s, t);
        System.out.println(res);
    }


}
