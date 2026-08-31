class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue <int[]> maxheap=new PriorityQueue<>((p1,p2)->Integer.compare((p2[0]*p2[0]+p2[1]*p2[1]),(p1[0]*p1[0]+p1[1]*p1[1])));

        for(int[] point : points){
            maxheap.offer(point);
            if(maxheap.size()>k){
                maxheap.poll();
            }
        }
        int result[][]=new int[k][2];
        for(int i=0;i<k;i++){
            result[i]=maxheap.poll();
        }
        return result;
    }
}