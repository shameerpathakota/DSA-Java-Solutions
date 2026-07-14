class Solution {
    int n;
    public boolean checkValidGrid(int[][] grid) {
        n = grid.length;
        return solve(grid, 0, 0, 0);
    }

    boolean solve(int[][] grid, int row, int col, int expval){
        if(row >= n || col >= n || row < 0 || col < 0 || grid[row][col] != expval){
            return false;
        }

        if(expval == n*n - 1){
            return true;
        }

        boolean ans1 = solve(grid, row-2, col+1, expval+1);
        boolean ans2 = solve(grid, row-1, col+2, expval+1);
        boolean ans3 = solve(grid, row+1, col+2, expval+1);
        boolean ans4 = solve(grid, row+2, col+1, expval+1);
        boolean ans5 = solve(grid, row+2, col-1, expval+1);
        boolean ans6 = solve(grid, row+1, col-2, expval+1);
        boolean ans7 = solve(grid, row-1, col-2, expval+1);
        boolean ans8 = solve(grid, row-2, col-1, expval+1);

        return ans1 || ans2 || ans3 || ans4 || ans5 || ans6 || ans7 || ans8;
    }
}