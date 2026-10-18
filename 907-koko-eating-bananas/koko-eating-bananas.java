class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left=1;
        int right=0;
        for(int pile:piles){
            right=Math.max(right,pile);
        }
        int result=right;
        while(left<=right){
            int mid=left+(right-left)/2;

        
        long totalhours=0;
        for(int pile:piles){
            totalhours+=(pile+mid-1)/mid;
        }

        if(totalhours<=h){
            result=mid;
            right=mid-1;
        }else{
            left=mid+1;
        }
        }
        return result;
        
    }
}