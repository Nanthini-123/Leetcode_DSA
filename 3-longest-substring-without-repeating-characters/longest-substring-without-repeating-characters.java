class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> set=new HashSet<>();
        int left=0;
        int max=0;
        for(int right=0;right<s.length();right++){
            char currentchar=s.charAt(right);

            while(set.contains(currentchar)){
                set.remove(s.charAt(left));
                left++;
            }

            set.add(currentchar);
            max=Math.max(max, right-left+1);
        }
        return max;
        
    }
}