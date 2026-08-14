class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        int[][] dp = new int[n][m];
        for(int[] arr : dp){
            Arrays.fill(arr, -1);
        }

        int maxi = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                maxi = Math.max(maxi, findseq(i, j, n, m, -1, matrix, dp));
            }
        }

        return maxi;
    }

    int findseq(int i, int j, int n, int m, int prev, int[][] matrix, int[][] dp){
        if(i < 0 || i == n || j < 0 || j == m || matrix[i][j] <= prev){
            return 0;
        }

        if(dp[i][j] != -1){
            return dp[i][j];
        }

        int up = findseq(i-1, j, n, m, matrix[i][j], matrix, dp);
        int down = findseq(i+1, j, n, m, matrix[i][j], matrix, dp);
        int left = findseq(i, j-1, n, m, matrix[i][j], matrix, dp);
        int right = findseq(i, j+1, n, m, matrix[i][j], matrix, dp);

        int ans = 1 + Math.max(left, Math.max(right, Math.max(up, down)));

        dp[i][j] = ans;

        return ans;
    }
}
//practice session 39.