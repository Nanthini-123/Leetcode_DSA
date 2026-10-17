class Solution {
    public int characterReplacement(String s, int k) {
        int[] count=new int[26];
        int left=0;
        int maxfrequency=0;
        int maxlen=0;
        for(int right=0;right<s.length();right++){
            count[s.charAt(right)-'A']++;
            maxfrequency=Math.max(maxfrequency,count[s.charAt(right)-'A']);
            while((right-left+1)-maxfrequency>k){
                count[s.charAt(left)-'A']--;
                left++;
            }
            maxlen=Math.max(maxlen,right-left+1);
        }
        return maxlen;

        
    }
}