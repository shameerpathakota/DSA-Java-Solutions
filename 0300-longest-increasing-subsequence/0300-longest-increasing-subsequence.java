class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n+1][n+1];
        for(int[] arr : dp){
            Arrays.fill(arr, -1);
        }
        return solve(nums, 0, -1, dp);
    }

    int solve(int[] nums, int i, int prev, int[][] dp){
        if(i >= nums.length){
            return 0;
        }

        if(dp[i][prev+1] != -1){
            return dp[i][prev+1];
        }
        

        int take = 0;
        if(prev == -1 || (nums[i] > nums[prev])){
            take = 1 + solve(nums, i+1, i, dp);
        }
        int skip = solve(nums, i+1, prev, dp);

        return dp[i][prev+1] = Math.max(take, skip);
    }
}