class Solution {
    List<List<String>> ans;
    private List<String> createBoard(char[][] board1) {
        List<String> board = new ArrayList<String>();
        for (int row = 0; row < board1.length; row++) {
            String current_row = new String(board1[row]);
            board.add(current_row);
        }

        return board;
    }
    public void fillBoard(char[][] board, Set<Integer> col, Set<Integer> diagonal, Set<Integer> antiDiagonal, int i){
        if(i==board.length) {
            ans.add(createBoard(board));
            return;
        }
        
        for(int j=0;j<board.length;j++){
            int currDiagonal = i-j;
            int currAntiDiagonal = i+j;
            if(!(col.contains(j) || diagonal.contains(currDiagonal) || antiDiagonal.contains(currAntiDiagonal))){
                col.add(j);
                diagonal.add(currDiagonal);
                antiDiagonal.add(currAntiDiagonal);
                board[i][j]='Q';
                fillBoard(board, col, diagonal, antiDiagonal, i+1);
                board[i][j]='.';
                col.remove(j);
                diagonal.remove(currDiagonal);
                antiDiagonal.remove(currAntiDiagonal);
            }
        }
    }
    public List<List<String>> solveNQueens(int n) {
        ans = new ArrayList<>();
        char board[][] = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }
        fillBoard(board, new HashSet<>(), new HashSet<>(), new HashSet<>(), 0);
        return ans;
    }
}