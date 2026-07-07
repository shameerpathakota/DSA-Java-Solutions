class Solution {
    int n = 0;
    int m = 0;
    public boolean exist(char[][] board, String word) {
        n = board.length;
        m = board[0].length;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(board[i][j] == word.charAt(0)){
                    if(findWord(board, i, j, 0, word)){
                        return true;
                    }
                }
            }
        }

        return false;
    }

    boolean findWord(char[][] board, int i, int j, int index, String word){
        if(index == word.length()){
            return true;
        }

        if(i < 0 || j < 0 || i >= n || j >= m || board[i][j] == '$'){
            return false;
        }

        if(board[i][j] != word.charAt(index)){
            return false;
        }

        char temp = board[i][j];
        board[i][j] = '$';

        //righ call

        boolean right = findWord(board, i, j+1, index+1, word);
        boolean left = findWord(board, i, j-1, index+1, word);
        boolean top = findWord(board, i-1, j, index+1, word);
        boolean down = findWord(board, i+1, j, index+1, word);


        if(right || left || top || down){
            return true;
        }

        board[i][j] = temp;

        return false;
    }
}