class Solution {
    public int numIslands(char[][] grid) {
        if(grid==null||grid.length==0){
            return 0;
        }

        int rows=grid.length;
        int cols=grid[0].length;
        int islandcount=0;

        for(int r=0;r<rows;r++){
            for(int c=0;c<cols;c++){
                if(grid[r][c]=='1'){
                    islandcount++;

                    sinkisland(grid,r,c);
                }
            }
        }
        return islandcount;
        
    }
    public void sinkisland(char[][]grid,int r,int c){
        int rows=grid.length;
        int cols=grid[0].length;

        if(r<0||r>=rows||c<0||c>=cols||grid[r][c]=='0'){
            return;
        }

        grid[r][c]='0';

        sinkisland(grid,r+1,c);
        sinkisland(grid,r-1,c);
        sinkisland(grid,r,c+1);
        sinkisland(grid,r,c-1);

    }
}