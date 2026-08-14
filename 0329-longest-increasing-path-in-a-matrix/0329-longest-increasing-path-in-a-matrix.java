class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] dp = new int[n][m];
        for(int[] arr : dp){
            Arrays.fill(arr, -1);
        }

        int max = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                max = Math.max(max, solve(i, j, -1, n, m, matrix, dp));
            }
        }

        return max;
    }

    int solve(int i, int j, int prev, int n, int m, int[][] matrix, int[][] dp){
        if(i < 0 || i >= n || j < 0 || j >= m || matrix[i][j] <= prev){
            return 0;
        }
        if(dp[i][j] != -1){
            return dp[i][j];
        }

        int up = solve(i-1, j, matrix[i][j], n, m, matrix, dp);
        int down = solve(i+1, j, matrix[i][j], n, m, matrix, dp);
        int left = solve(i, j-1, matrix[i][j], n, m, matrix, dp);
        int right = solve(i, j+1, matrix[i][j], n, m, matrix, dp);

        int ans = 1 + Math.max(up, Math.max(down, Math.max(left, right)));

        return dp[i][j] = ans;

    }
}