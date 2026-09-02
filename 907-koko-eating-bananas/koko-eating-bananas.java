class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left=1;
        int right=0;
        for(int pile:piles){
            right=Math.max(right, pile);
        }
        while(left<right){
            int mid=left+(right-left)/2;
            if(caneatall(piles,h,mid)){
                right=mid;
            }else{
                left=mid+1;
            }
        }
        return left;
        
    }
    public boolean caneatall(int[]piles, int h, int k){
        int totalhours=0;
        for(int pile:piles){
            totalhours+=(pile+k-1)/k;
        }
        return totalhours<=h;


    }
}