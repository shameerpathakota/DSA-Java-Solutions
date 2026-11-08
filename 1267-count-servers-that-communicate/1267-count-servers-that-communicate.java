class Solution {
    public int countServers(int[][] grid) {
        int count = 0;
        int n = grid.length;
        int m = grid[0].length;

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == 1){
                    if(communicate(grid, i, j)){
                        count++;
                    }
                }
            }
        }

        return count;
    }

    boolean communicate(int[][] grid, int i, int j){
        for(int row = 0; row < grid.length; row++){
            if(row == i){
                continue;
            }
            if(grid[row][j] == 1){
                return true;
            }
        }

        for(int col = 0; col < grid[0].length; col++){
            if(col == j){
                continue;
            }
            if(grid[i][col] == 1){
                return true;
            }
        }

        return false;
    }
}