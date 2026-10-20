class Solution {
    public int orangesRotting(int[][] grid) {
        if(grid==null||grid.length==0){
            return 0;
        }
        int rows=grid.length;
        int cols=grid[0].length;
        Queue<int[]>queue=new LinkedList<>();
        int freshoranges=0;

        for(int r=0;r<rows;r++){
            for(int c=0;c<cols;c++){
                if(grid[r][c]==2){
                    queue.offer(new int[]{r,c});

                }else if(grid[r][c]==1){
                    freshoranges++;
                }                
            }
        }

        if(freshoranges==0){
            return 0;
        }

        int min=0;
        int [][] directions={{-1,0},{1,0},{0,-1},{0,1}};
        while(!queue.isEmpty()&&freshoranges>0){
            int size=queue.size();
            min++;

            for(int i=0;i<size;i++){
                int[]current=queue.poll();
                int currrow=current[0];
                int currcol=current[1];

                for(int [] dir:directions){
                    int nextrow=currrow+dir[0];
                    int nextcol=currcol+dir[1];


                    if(nextrow>=0&&nextrow<rows&&nextcol>=0&&nextcol<cols&&grid[nextrow][nextcol]==1){
                        grid[nextrow][nextcol]=2;
                        freshoranges--;
                        queue.offer(new int[]{nextrow,nextcol});
                    }
                }
            }
        }
        return freshoranges==0?min:-1;


        
    }
}