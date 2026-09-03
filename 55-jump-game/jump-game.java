class Solution {
    public boolean canJump(int[] nums) {
        int maxreachable=0;
        for(int i=0;i<nums.length;i++){
            if(i>maxreachable){
                return false;
            }
            maxreachable=Math.max(maxreachable,i+nums[i]);

            if(maxreachable>=nums.length-1){
                return true;
            }
        }
        return true;
    }
}