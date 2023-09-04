public class JumpGame {
    public boolean canJump(int[] nums) {
        int pos = 0;
        int nextPos;
        while(true){
            nextPos = findNextPos(nums,pos);
            if(nextPos==-1){
                return false;
            }
            if(nextPos>=nums.length-1){
                return true;
            }
            pos = nextPos;
        }

    }

    public int findNextPos(int[] nums, int pos){
        // find next position start from pos
        int nextPos = pos;
        for(int i=pos;i<=pos+nums[pos];i++){
            if(i>=nums.length-1){
                return nums.length;
            }
            if(nums[i]+i>nums[nextPos]+nextPos){
                nextPos = i;
            }
        }
        if(nextPos==pos){
            return -1;
        }
        return nextPos;
    }
}
