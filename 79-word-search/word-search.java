class Solution {
    public boolean exist(char[][] board, String word) {
        int rows=board.length;
        int cols=board[0].length;
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(board[i][j]==word.charAt(0)){
                    if(backtrack(board,word,i,j,0)){
                        return true;
                    }
                }
            }
        }
        return false;
        
    }

    public boolean backtrack(char[][] board,String word,int i,int j, int index ){

        if(i<0||i>=board.length||j<0||j>=board[0].length||board[i][j]!=word.charAt(index)){
            return false;
        }
        if(index==word.length()-1){
            return true;
        }

        char originalchar=board[i][j];
        board[i][j]='#';

        boolean found= backtrack(board,word,i+1,j,index+1)||backtrack(board,word,i-1,j,index+1)||backtrack(board,word,i,j+1,index+1)||backtrack(board,word,i,j-1,index+1);

        board[i][j]=originalchar;

        return found;

    }
}