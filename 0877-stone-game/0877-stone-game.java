class Solution {
    public boolean stoneGame(int[] piles) {
        int[][] dp = new int[501][501];
        for(int[] arr : dp){
            Arrays.fill(arr, -1);
        }
        int n = piles.length;
        int sum = 0;
        for(int num : piles){
            sum += num;
        }

        int alice_score = solve(piles, 0, n-1, dp);

        return (alice_score > sum/2);
    }

    public int solve(int[] nums, int i, int j, int[][]dp){

        if(i > j){
            return 0;
        }

        if(dp[i][j] != -1){
            return dp[i][j];
        }

        int take_i = nums[i] + Math.min(solve(nums, i+2, j, dp), solve(nums, i+1, j-1, dp));
        int take_j = nums[j] + Math.min(solve(nums, i+1, j-1, dp), solve(nums, i, j-2, dp));

        return dp[i][j] = Math.max(take_i, take_j);
    }
}