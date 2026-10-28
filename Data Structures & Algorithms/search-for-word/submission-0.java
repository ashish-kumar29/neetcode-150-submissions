class Solution {
    int[][] directions = {
            {-1, 0}, // Up:    move row - 1
            {1, 0},  // Down:  move row + 1
            {0, -1}, // Left:  move col - 1
            {0, 1}   // Right: move col + 1
        };
    public boolean wordExist(char[][] board, String word, int i, int j, int idx){
        if(idx==word.length()) return true;
        for(int[] dir:directions){
            int i1=i+dir[0], j1=j+dir[1];
            if(i1<0 || i1>=board.length || j1<0 || j1>=board[0].length) continue;
            char c = board[i1][j1];
            if(c==word.charAt(idx)){
                board[i1][j1]='@';
                if(wordExist(board, word, i1, j1, idx+1)) return true;
                board[i1][j1]=c;
            }
        }
        return false;
    }
    public boolean exist(char[][] board, String word) {
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j]==word.charAt(0)){
                    board[i][j]='@';
                    if(wordExist(board, word, i, j, 1)) return true;
                    board[i][j]=word.charAt(0);
                }
            }
        }
        return false;
    }
}