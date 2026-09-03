class Solution {
    public int longestOnes(int[] nums, int k) {
        int left=0;
        int maxlength=0;
        int zeroes=0;
        for(int right=0;right<nums.length;right++){
            if(nums[right]==0){
                zeroes++;
            }
            while(zeroes>k){
                if(nums[left]==0){
                    zeroes--;
                }
                left++;
            }
            maxlength=Math.max(maxlength,right-left+1);
        }
        
        return maxlength;
    }
}