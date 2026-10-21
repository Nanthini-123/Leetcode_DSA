class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        if(grid==null||grid.length==0){
            return 0;
        }

        int rows=grid.length;
        int cols=grid[0].length;
        int maxarea=0;
        for(int r=0;r<rows;r++){
            for(int c=0;c<cols;c++){
                if(grid[r][c]==1){
                    maxarea=Math.max(maxarea,calculatearea(grid,r,c));
                }
            }
        }
        return maxarea;
        
    }
    public int calculatearea(int[][]grid,int r, int c){
        if(r<0||r>=grid.length||c<0||c>=grid[0].length||grid[r][c]==0){
            return 0;
        }

        grid[r][c]=0;

        return 1+calculatearea(grid,r+1,c)+calculatearea(grid,r-1,c)+calculatearea(grid,r,c+1)+calculatearea(grid,r,c-1);
    }
}