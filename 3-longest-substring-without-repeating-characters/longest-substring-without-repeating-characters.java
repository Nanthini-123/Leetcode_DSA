class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer>map=new HashMap<>();
        int left=0;
        int maxlen=0;
        for(int right=0;right<s.length();right++){
            char current=s.charAt(right);
            if(map.containsKey(current)){
                left=Math.max(left,map.get(current)+1);
            }
            map.put(current,right);
            maxlen=Math.max(maxlen,right-left+1);

        }
        return maxlen;
        
    }
}