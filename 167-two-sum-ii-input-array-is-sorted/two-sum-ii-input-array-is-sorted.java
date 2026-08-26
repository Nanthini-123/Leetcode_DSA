class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int left=0;
        int right=numbers.length-1;
        
        while(left<right){
            int currentsum=numbers[left]+numbers[right];
            if(currentsum==target){
                return new int[]{left+1,right+1};
            }
            if(currentsum<target){
                left++;
            }else{
            right--;
            }
        }
        return new int[] {-1,-1};
        
    }
}