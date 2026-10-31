class Solution {
    int LEFT = 0;
    int UP = 1;
    int m, n;
    int mod = 1000000007;
    public int uniquePaths(int[][] grid) {
        m = grid.length;
        n = grid[0].length;

        int[][][] dp = new int[m+1][n+1][2];
        for(int[][] arr : dp){
            for(int[] nums : arr){
                Arrays.fill(nums, -1);
            }
        }

        return solve(grid, 0, 0, UP, dp);
    }

    int solve(int[][] grid, int r, int c, int ComeFrom, int[][][] dp){
        if(r == m-1 && c == n-1){
            return 1;
        }

        if(dp[r][c][ComeFrom] != -1){
            return dp[r][c][ComeFrom];
        }

        if(r >= m || c >= n){
            return 0;
        }

        if(grid[r][c] == 1){
            if(ComeFrom == UP){
                return dp[r][c][ComeFrom] = solve(grid, r, c+1, LEFT, dp) % mod;
            }
            else{
                return dp[r][c][ComeFrom] = solve(grid, r+1, c, UP, dp) % mod;
            }
        }

        int totalcount = 0;

        totalcount = (totalcount + solve(grid, r, c+1, LEFT, dp)) % mod;
        totalcount = (totalcount + solve(grid, r+1, c, UP, dp)) % mod;

        return dp[r][c][ComeFrom] = totalcount;

    }
}