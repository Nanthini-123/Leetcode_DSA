class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length()){
            return false;
        }
        int charcount[] = new int[26];
        for(int i=0;i<s.length();i++){
        charcount[s.charAt(i)-'a']++;
        charcount[t.charAt(i)-'a']--;

        }
        for(int count:charcount){
            if(count!=0){
                return false;
            }
        }
        return true;
    }
}