import java.util.Arrays;

public class OneAndZero {
    public int findMaxForm(String[] strs, int m, int n) {
        // dp[i][j]: largest subset that there are at most i 0 and j 1;
        int[][] dp = new int[m+1][n+1];
        for(int i=0;i<strs.length;i++){
           long zero = strs[i].chars().filter(ch->ch=='0').count();
           long one = strs[i].chars().filter(ch->ch=='1').count();
           for(int j=m;j>=zero;j--){
               for(int k=n;k>=one;k--){
                   dp[j][k] = Math.max(dp[j][k], dp[j-(int)zero][k-(int)one]+1);
               }
           }
           System.out.println(Arrays.deepToString(dp));
        }

        return dp[m][n];

    }


    public static void main(String[] args) {
        OneAndZero sol = new OneAndZero();
        String[] strs = new String[]{"10","0001","111001","1","0"};
        int m = 5;
        int n = 3;
        sol.findMaxForm(strs,m,n);


    }

}
