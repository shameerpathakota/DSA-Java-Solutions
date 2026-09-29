class Solution {
    int m;
    int n;
    public boolean hasValidPath(char[][] grid) {
        m = grid.length;
        n = grid[0].length;
        int[][][] dp = new int[m+1][n+1][201];
        for(int[][] arr : dp){
            for(int[] nums : arr){
                Arrays.fill(nums, -1);
            }
        }

        if(grid[0][0] == ')' || grid[m-1][n-1] == '('){
            return false;
        }

        if(m+n-1 % 2 == 1){
            return false;
        }

        return solve(0, 0, 0, grid, dp);
    }

    boolean solve(int i, int j, int opencount, char[][] grid, int[][][] dp){
        opencount += (grid[i][j] == '(' ? 1 : -1);


        if(opencount < 0){
            return false;
        }

        if(dp[i][j][opencount] != -1){
            return dp[i][j][opencount] == 1;
        }

        
        if(i == m-1 && j == n-1){
            dp[i][j][opencount] = (opencount == 0 ? 1 : 0);
            return opencount == 0;
        }

        //down move
        if(i+1 < m){
            if(solve(i+1, j, opencount, grid, dp)){
                dp[i][j][opencount] = 1;
                return true;
            }
        }

        //right move
        if(j+1 < n){
            if(solve(i, j+1, opencount, grid, dp)){
                dp[i][j][opencount] = 1;
                return true;
            }
        }


        dp[i][j][opencount] = 0;
        return false;

    }
}