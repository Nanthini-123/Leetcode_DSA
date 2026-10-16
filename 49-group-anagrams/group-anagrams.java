class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if(strs==null||strs.length==0){
            return new ArrayList<>();
        }
        HashMap <String,List<String>>map=new HashMap<>();
        for(String s:strs){
            char[] chararr=s.toCharArray();

            Arrays.sort(chararr);
            String sorted=String.valueOf(chararr);

            if(!map.containsKey(sorted)){
                map.put(sorted,new ArrayList<>());
            }
            map.get(sorted).add(s);

        }
        return new ArrayList(map.values());

        
    }
}