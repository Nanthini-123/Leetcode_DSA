class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums==null||nums.length==0){
            return 0;
        }

        HashSet<Integer> set=new HashSet<>();
        for(int num:nums){
            set.add(num);
        }
        int maxlength=0;
        for(int num:set){
            if(!set.contains(num-1)){
                int currentnum=num;
                int currentlen=1;

                while(set.contains(currentnum+1)){
                    currentnum+=1;
                    currentlen+=1;
                }
                maxlength=Math.max(currentlen, maxlength);
            }
            
        }
        return maxlength;
    }
}