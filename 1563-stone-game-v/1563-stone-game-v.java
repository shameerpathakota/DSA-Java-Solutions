class Solution {
    public int stoneGameV(int[] stoneValue) {
        
        if(stoneValue.length == 1){
            return 0;
        }

        int[] prefix = new int[stoneValue.length];
        prefix[0] = stoneValue[0];
        for(int i = 1; i < stoneValue.length; i++){
            prefix[i] = prefix[i-1] + stoneValue[i];
        }
        int n = stoneValue.length;
        int[][] dp = new int[n][n];
        for(int[] arr : dp){
            Arrays.fill(arr, -1);
        }

        return solve(0, n-1, prefix, dp);
    }

    int solve(int l, int r, int[] prefix, int[][] dp){
        if(l >= r){
            return 0;//no more divisions are possible
        }

        if(dp[l][r] != -1){
            return dp[l][r];
        }

        int score = 0;
        for(int mid = l; mid <= r-1; mid++){
            int leftsum = prefix[mid] - (l-1 >= 0 ? prefix[l-1] : 0);
            int rightsum = prefix[r] - prefix[mid];

            if(leftsum < rightsum){
                score = Math.max(score, leftsum + solve(l, mid, prefix, dp));
            }
            else if(leftsum > rightsum){
                score = Math.max(score, rightsum + solve(mid+1, r, prefix, dp));
            }
            else{
                score = Math.max(score, Math.max(leftsum + solve(l, mid, prefix, dp),rightsum + solve(mid+1, r, prefix, dp)));
            }
        }

        return dp[l][r] = score;
    }
}