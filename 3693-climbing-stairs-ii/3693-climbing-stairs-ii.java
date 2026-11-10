class Solution {
    public int climbStairs(int n, int[] costs) {
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);
        return solve(costs, n, 0, dp);
    }

    int solve(int[] costs, int n, int i, int[] dp){
        if(i >= n){
            return 0;
        }

        if(dp[i] != -1){
            return dp[i];
        }
        int temp1 = Integer.MAX_VALUE;
        int temp2 = Integer.MAX_VALUE;
        int temp3 = Integer.MAX_VALUE;
        int j = i+1;
        if(j <= n){
            temp1 = costs[j-1] + (j-i) * (j-i) + solve(costs, n, j, dp);
        }
        j = i+2;
        if(j <= n){
            temp2 = costs[j-1] + (j-i) * (j-i) + solve(costs, n, j, dp);
        }
        j = i+3;
        if(j <= n){
            temp3 = costs[j-1] + (j-i) * (j-i) + solve(costs, n, j, dp);
        }

        return dp[i] = Math.min(temp1, Math.min(temp2, temp3));
    }
}