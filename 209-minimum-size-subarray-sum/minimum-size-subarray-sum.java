class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int left=0;
        int minlength=Integer.MAX_VALUE;
        int currentsum=0;
        for(int right=0;right<nums.length;right++){
            currentsum+=nums[right];
            while(currentsum>=target){
                minlength=Math.min(minlength,right-left+1);

                currentsum-=nums[left];
                left++;
            }
            
        }
        return minlength==Integer.MAX_VALUE?0:minlength;

        
    }
}