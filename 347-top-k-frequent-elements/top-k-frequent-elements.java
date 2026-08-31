class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map=new HashMap<>();
        for(int num:nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }
            PriorityQueue<Integer> minheap=new PriorityQueue<>((n1,n2)-> Integer.compare(map.get(n1),map.get(n2)));

            for(int num:map.keySet()){
                minheap.offer(num);
                if(minheap.size()>k){
                    minheap.poll();
                }
            }

            int[]result=new int[k];
            for(int i=0;i<k;i++){
                result[i]=minheap.poll();
            }
            return result;

        
    }
}