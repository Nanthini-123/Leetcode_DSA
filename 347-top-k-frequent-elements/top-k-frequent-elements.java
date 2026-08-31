class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map=new HashMap<>();
        for(int num:nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }
            List<Integer>[] Bucket=new List[nums.length+1];

            for(int key:map.keySet()){
                int frequency=map.get(key);
                if(Bucket[frequency]==null){
                    Bucket[frequency]=new ArrayList<>();

                }
                    Bucket[frequency].add(key);
                
            }
                int [] result=new int[k];
                int resultindex=0;
                for(int i=Bucket.length-1;i>=0&&resultindex<k;i--){
                    if(Bucket[i]!=null){
                        for(int num:Bucket[i]){
                            result[resultindex++]=num;
                            if(resultindex==k){
                                return result;
                            }
                        }
                    }
                }

        return result;
    }
}