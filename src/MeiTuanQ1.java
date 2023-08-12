import java.util.Scanner;
public class MeiTuanQ1 {

    public static boolean isNext(int[] nums, int x, int y){
        if(nums.length<=1){
            return false;
        }

        for(int i=0;i<nums.length-1;i++){
            if(nums[i] ==x){
                if(i==0 && nums[i+1]==y){
                    return true;
                }  else if(i!=0 && (nums[i-1]==y || nums[i+1]==y)){
                    return true;
                }
            }
            if(nums[i]==y){
                if(i==0 && nums[i+1]==x){
                    return true;
                }  else if(i!=0 && (nums[i-1]==x || nums[i+1]==x)){
                    return true;
                }

            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [] nums = new int[n];
        for(int i = 0; i < n; i++){
            nums[i] = sc.nextInt();
        }
        int x = sc.nextInt();
        int y = sc.nextInt();

//        int [] nums = {2,3};
//        int x = 3; int y= 2;

        boolean res= isNext(nums,x,y);
        if(res){
            System.out.println("Yes");
        }else{
            System.out.println("No");
        }
    }
}
