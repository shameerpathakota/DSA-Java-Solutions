class Solution {
    int n;
    public int paintWalls(int[] cost, int[] time) {
        n = time.length;
        int[][] dp = new int[n][n+1];
        for(int[] arr : dp){
            Arrays.fill(arr, -1);
        }
        return solve(cost, time, 0, n, dp);
    }

    int solve(int[] cost, int[] time, int index, int remaining, int[][] dp){
        if(remaining <= 0){
            return 0;
        }
        if(index >= n){
            return 1_000_000_000;//Integer.MAX_VALUE may cause the integer overflow so instead of that use the above one
        }

        if(dp[index][remaining] != -1){
            return dp[index][remaining];
        }

        int paint_idx = cost[index] + solve(cost, time, index+1, remaining-1-time[index], dp);
        int no_paint = solve(cost, time, index+1, remaining, dp);

        return dp[index][remaining] = Math.min(paint_idx, no_paint);
    }
}