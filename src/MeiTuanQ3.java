public class MeiTuanQ3 {

    public static int minValue(int[][] nums){
        int sum = 0;
        for(int i=0;i<nums.length;i++){
            for(int j=0;j<nums[i].length;j++){
                sum += nums[i][j];
            }
        }

        int s1;
        int curMin = sum;
        // cut by row
        for(int i=0;i<nums.length;i++) {
            s1 = 0;
            for (int j = 0; j < nums[i].length; j++) {
                    s1 += nums[i][j];
            }
            // cut by row i
            if(Math.abs(s1*2-sum)< curMin){
                curMin =  Math.abs(s1*2-sum);
                if(curMin==0){
                    return 0;
                }
            }
        }
        // cut by col
        for(int j=0;j<nums[0].length;j++) {
            s1 = 0;
            for (int i = 0; i < nums.length; i++) {
                s1 += nums[i][j];
            }
            // cut by col j
            if(Math.abs(s1*2-sum)< curMin){
                curMin =  Math.abs(s1*2-sum);
                if(curMin==0){
                    return 0;
                }
            }
        }

        return curMin;
    }

    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int m = sc.nextInt();
//
//        int [][] nums = new int[n][m];
//        for(int i = 0; i < n; i++){
//            for(int j=0;j<m;j++) {
//                nums[i][j] = sc.nextInt();
//            }
//        }
//        System.out.println(minValue(nums));

        int m = 2;
        int n = 3;
        int [][] nums = {{1,1,4},{5,1,4}};
        System.out.println(minValue(nums));

    }
}
