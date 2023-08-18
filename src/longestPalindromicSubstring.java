import java.util.Arrays;
import java.util.Collection;
import java.util.Map;
import java.util.concurrent.LinkedTransferQueue;

public class longestPalindromicSubstring {
//    public String longestPalindrome(String s) {
//        int[] best = new int[]{0, 0};
//        // center with one item
//        for (int mid = 0; mid < s.length(); mid++) {
//            int left = mid - 1;
//            int right = mid + 1;
//            int[] curLongest = seachLongest(left,right,s);
//            if((curLongest[1]-curLongest[0])>(best[1]-best[0])){
//                best = curLongest;
//            }
//        }
//        // center with two item
//        for (int mid = 0; mid < s.length() - 1; mid++) {
//            if (s.charAt(mid) == s.charAt(mid + 1)) {
//                int left = mid - 1;
//                int right = mid + 2;
//                int[] curLongest = seachLongest(left,right,s);
//                if((curLongest[1]-curLongest[0])>(best[1]-best[0])){
//                    best = curLongest;
//                }
//            }
//        }
//
//        return s.substring(best[0], best[1]+1);
//    }
//
//    public int[] seachLongest(int left, int right, String s){
//        while (left >= 0 && right < s.length()) {
//            if (s.charAt(left)!= s.charAt(right)) {
//                break;
//            }
//            left -= 1;
//            right += 1;
//        }
//        return new int[]{left+1,right-1};
//    }

    public String longestPalindrome(String s) {
        int n = s.length();
        boolean [][] dp  = new boolean[n][n];
        //init
        for (int i=0;i<n;i++){
            for (int j=0;j<n;j++){
                dp[i][j] = false;
            }
        }
        // len =1
        for(int i=0;i<n;i++){
            dp[i][i] = true;
        }
        //len = 2
        for(int i=0;i<n-1;i++){
            if(s.charAt(i)==s.charAt(i+1)){
                dp[i][i+1] = true;
            }
        }
        //len = 3 to n
        for(int lens=3;lens<=n;lens++){
            for(int i=0;i<=n-lens;i++){
                if( dp[i+1][i+lens-2] == true && s.charAt(i)==s.charAt(i+lens-1)){
                    dp[i][i+lens-1] = true;
                }
            }
        }
        int [] best = new int[]{0,0};
        for (int i=0;i<n;i++){
            for (int j=0;j<n;j++){
                if(dp[i][j] ==true){
                    if((j-i)>(best[1]-best[0])){
                        best[0] = i;
                        best[1] = j;
                    }
                }
            }
        }

        return s.substring(best[0],best[1]+1);

    }




    public static void main(String[] args) {
        longestPalindromicSubstring sol = new longestPalindromicSubstring();

        String s =sol.longestPalindrome("cbbd");
        System.out.println(s);
    }

}
