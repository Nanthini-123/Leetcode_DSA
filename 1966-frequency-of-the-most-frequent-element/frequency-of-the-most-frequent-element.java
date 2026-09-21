class Solution {
    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        int left=0;
        long currentsum=0;
        int maxfreq=0;
        for(int right=0;right<nums.length;right++){
            currentsum+=nums[right];

            while((long)nums[right]*(right-left+1)-currentsum>k){
                currentsum-=nums[left];
                left++;
            }
            maxfreq=Math.max(maxfreq,right-left+1);
        }
        return maxfreq;
    }
}