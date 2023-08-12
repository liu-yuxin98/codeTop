public class MeiTuanQ2 {


    public static int minDis(int[] nums, int x, int y){
        if(x==y){
            return 0;
        }

        int px = Math.min(x-1,y-1);
        int py = Math.max(x-1,y-1);
        int pz = px+nums.length;
        int [] distances = new int[nums.length*2-1];
        for(int i=0;i<distances.length;i++){
            distances[i] = nums[i%nums.length];
        }

        int dis1 = 0;
        for(int i =px;i<py;i++){
            dis1 += distances[i];
        }
        int dis2 = 0;
        for (int i=py;i<pz;i++){
            dis2 += distances[i];
        }
        return Math.min(dis1,dis2);
    }

    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int [] nums = new int[n];
//        for(int i = 0; i < n; i++){
//            nums[i] = sc.nextInt();
//        }
//        int x = sc.nextInt();
//        int y = sc.nextInt();

        int [] nums = {1,1,1,8};
        int x = 4; int y= 1;
        System.out.println(minDis(nums,x,y));
    }
}
