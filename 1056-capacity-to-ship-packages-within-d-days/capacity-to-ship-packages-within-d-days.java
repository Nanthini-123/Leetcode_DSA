class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int maxweight=0;
        int totalweight=0;
        for(int weight:weights){
            maxweight=Math.max(maxweight,weight);
            totalweight+=weight;
        }
        int left=maxweight;
        int right=totalweight;
        int result=right;
        while(left<=right){
            int mid=left+(right-left)/2;
            if(canship(weights,days,mid)){
                result=mid;
                right=mid-1;

            }else{
                left=mid+1;
            }

        }
        return result;
    }
    private boolean canship(int []weights,int days,int capacity){
        int daysneeded=1;
        int currentload=0;
        for(int weight:weights){
            if(currentload+weight>capacity){
                daysneeded++;
                currentload=0;

            }
                currentload+=weight;
            
        }
        return daysneeded<=days;
    }
}