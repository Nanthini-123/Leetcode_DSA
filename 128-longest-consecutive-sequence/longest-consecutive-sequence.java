class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer>set=new HashSet<>();
        for(int num:nums){
            set.add(num);
        }
        int currentnum=0;
        int currentlen=0;
        int maxlen=0;
        for(int n:set){
            if(!set.contains(n-1)){
                currentnum=n;
                currentlen=1;

            }
            while(set.contains(currentnum+1)){
                currentnum+=1;
                currentlen+=1;
            }
            maxlen=Math.max(maxlen,currentlen);
        }
        return maxlen;
        
    }
}