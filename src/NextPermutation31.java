import java.util.Arrays;

public class NextPermutation31 {
    public void nextPermutation(int[] nums){
        for(int i=nums.length-1;i>=0;i--){
            if(i==0){
                // reverese nums
                reverse(nums,0,nums.length-1);
                return;
            }
            if(nums[i]>nums[i-1]){
                // find the smallest num > nums[i-1] in i->end
                for(int j=nums.length-1;j>=i;j--){
                    if(nums[j]>nums[i-1]){
                        swap(nums,i-1,j);
                        break;
                    }
                }
                // reverse from i to end
                reverse(nums, i, nums.length-1);
                return;
            }
        }

    }

    public void reverse(int [] nums, int x, int y){
        // reverse nums from x to y
        int mid = (x+y)/2;
        for(int i=x;i<=mid;i++){
            swap(nums,i,y+x-i);
        }
    }
    public void swap(int[] nums, int x,int y){
        int temp = nums[x];
        nums[x] = nums[y];
        nums[y] = temp;
    }
//    public void nextPermutation(int[] nums) {
//        for(int i=nums.length-1;i>=0;i--){
//            if(i!=0){
//                if(nums[i]>nums[i-1]){
//                    swap(nums,i,i-1);
//                    // sort from i-1 to end
//                    quicksort(nums,i,nums.length-1);
//                    return;
//                }
//            }
//            if(i==0){
//                quicksort(nums,0, nums.length-1);
//                return;
//            }
//        }
//    }

//    public void sort(int [] nums, int x, int y){
//        //sort nums from x to  y
//
//    }

    public void quicksort(int[] nums, int x, int y){
        if(x>=y){
            return;
        }
        int pivotIndex = partition(nums,x,y);
        quicksort(nums,x,pivotIndex-1);
        quicksort(nums,pivotIndex+1,y);
    }

    public int partition(int[] nums, int low, int high){
        int pivot = nums[high];
        int pivotIndexAfterPartition = low; // init value of pivot index
        
        // iterate though from low to high-1
        for(int i=low;i<high;i++){
            if(nums[i]<pivot){
                // move this num with the front
                swap(nums,i,pivotIndexAfterPartition);
                pivotIndexAfterPartition+=1;
            }
        }
        swap(nums,pivotIndexAfterPartition,high);
        // now pivot value is at lasterSmaller+1
        return pivotIndexAfterPartition;
    }



    public static void main(String[] args) {
        NextPermutation31 sol  = new NextPermutation31();
        int [] nums = {1,1,5};
        sol.nextPermutation(nums);
        System.out.println(Arrays.toString(nums));

    }

}
