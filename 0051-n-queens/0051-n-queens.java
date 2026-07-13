class Solution {
    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        List<List<String>> result = new ArrayList<>();
        place(board, result, 0);
        return result;
    }

    void place(char[][] board, List<List<String>> result, int row){
        if(row == board.length){
            saveanswer(board, result);
            return;
        }
        for(int j = 0; j < board.length; j++){
            if(isSafe(board, row, j)){
                board[row][j] = 'Q';
                place(board, result, row+1);
                board[row][j] = '.';
            }
        }
    }

    boolean isSafe(char[][] board, int row, int col){
        //up
        for(int i = row-1; i >= 0; i--){
            if(board[i][col] == 'Q'){
                return false;
            }
        }

        //diagonal up left
        for(int i = row-1, j = col - 1; i >= 0 && j >= 0; i--,j--){
            if(board[i][j] == 'Q'){
                return false;
            }
        }

        //diagonal up right
        for(int i = row-1, j = col + 1; i >= 0 && j < board.length; i--,j++){
            if(board[i][j] == 'Q'){
                return false;
            }
        }

        return true;
    }

    void saveanswer(char[][] board, List<List<String>> result){
        String row = "";
        List<String> Newboard = new ArrayList<>();
        for(int i = 0; i < board.length; i++){
            row = "";
            for(int j = 0; j < board.length; j++){
                if(board[i][j] == 'Q'){
                    row += 'Q';
                }
                else{
                    row += '.';
                }
            }
            Newboard.add(row);
        }
        result.add(Newboard);
    }
}