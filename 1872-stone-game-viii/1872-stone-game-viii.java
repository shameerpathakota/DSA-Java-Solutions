class Solution {
    int n;
    public int stoneGameVIII(int[] stones) {
        n = stones.length;
        int[] prefix = new int[n];
        prefix[0] = stones[0];

        for(int i = 1; i < n; i++){
            prefix[i] = prefix[i-1] + stones[i];
        }

        int[] dp = new int[n];
        dp[n-1] = prefix[n-1];
        for(int i = n-2; i >= 1; i--){
            int take = prefix[i] - dp[i+1];
            int skip = dp[i+1];

            dp[i] = Math.max(take, skip);
        }

        return dp[1];
    }

    // int solve(int i, int[] prefix, int[] dp){
    //     if(i == n-1){
    //         return prefix[n-1];
    //     }

    //     if(dp[i] != -1){
    //         return dp[i];
    //     }

    //     int take = prefix[i] - solve(i+1, prefix, dp);
    //     int skip = solve(i+1, prefix, dp);

    //     return dp[i] = Math.max(take, skip);
    // }
}