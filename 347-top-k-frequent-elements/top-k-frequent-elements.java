class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> countMap=new HashMap<>();
        for(int num:nums){
            countMap.put(num, countMap.getOrDefault(num,0)+1);            
        }
        PriorityQueue<Integer> minHeap=new PriorityQueue<>((a,b)->countMap.get(a)-countMap.get(b));
        for(int key:countMap.keySet()){
            minHeap.add(key);
            if(minHeap.size()>k){
                minHeap.poll();
            }
        }
        int result[]=new int[k];
        for(int i=k-1;i>=0;i--){
            result[i]=minHeap.poll();
        }
        return result;

        
        
    }
}