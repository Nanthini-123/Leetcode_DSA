class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if(strs==null||strs.length==0){
            return new ArrayList<>();
        }
        HashMap <String, List<String>> map=new HashMap<>();
        for(String s:strs){
            char[] charArray=s.toCharArray();
            Arrays.sort(charArray);

            String sortedkey=String.valueOf(charArray);

            if(!map.containsKey(sortedkey)){
                map.put(sortedkey, new ArrayList<>());
            }
            map.get(sortedkey).add(s);
        }

        return new ArrayList(map.values());

        
    }
}