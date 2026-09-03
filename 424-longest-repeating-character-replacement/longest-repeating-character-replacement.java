class Solution {
    public int characterReplacement(String s, int k) {
        int[] count=new int[26];
        int left=0;
        int maxfrequency=0;
        int maxlength=0;
        for(int right=0;right<s.length();right++){
            char rightchar=s.charAt(right);
            count[rightchar-'A']++;
            
        
        maxfrequency=Math.max(maxfrequency,count[rightchar-'A']);

        int windowlength=right-left+1;
        if(windowlength-maxfrequency>k){
            char leftchar=s.charAt(left);
            count[leftchar-'A']--;
            left++;
        }
        maxlength=Math.max(maxlength,right-left+1);
        }
        return maxlength;
    }
}