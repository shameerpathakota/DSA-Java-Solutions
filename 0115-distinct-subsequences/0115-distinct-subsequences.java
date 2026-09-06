class Solution {
    public int numDistinct(String s, String t) {
        int[][] dp = new int[s.length()+1][t.length()+1];
        for(int[] arr : dp){
            Arrays.fill(arr, -1);
        }
        int m = s.length();
        int n = t.length();
        return helper(s, t, m, n, dp);
    }

    int helper(String s, String t, int m, int n, int[][] dp){
        if(n == 0){
            return 1;
        }

        if(m == 0){
            return 0;
        }

        if(dp[m][n] != -1){
            return dp[m][n];
        }

        if(s.charAt(m-1) == t.charAt(n-1)){
            return dp[m][n] = helper(s, t, m-1, n-1, dp) + helper(s, t, m-1, n, dp);
        }

        return dp[m][n] = helper(s, t, m-1, n, dp);
    }
}