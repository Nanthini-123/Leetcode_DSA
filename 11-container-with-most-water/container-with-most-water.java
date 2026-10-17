class Solution {
    public int maxArea(int[] height) {
        int left=0;
        int maxwater=0;
        int r=height.length-1;
        while(left<r){
            int width=r-left;
            int minheight=Math.min(height[r],height[left]);
            int currwater=width*minheight;
            maxwater=Math.max(currwater,maxwater);

            if(height[left]<height[r]){
                left++;
            }else{
                r--;
            }
        }
        return maxwater;
    }
}