class Solution {
    public String stoneGameIII(int[] stoneValue) {
        int n = stoneValue.length;
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);
        int diff = solve(stoneValue, 0, dp);
        if(diff < 0){
            return "Bob";
        }
        else if(diff > 0){
            return "Alice";
        }

        return "Tie";
    }

    int solve(int[] nums, int i, int[] dp){
        if(i >= nums.length){
            return 0;
        }

        if(dp[i] != -1){
            return dp[i];
        }

        int result = Integer.MIN_VALUE;

        result = Math.max(result, nums[i] - solve(nums, i+1, dp));

        if(i+1 < nums.length){
            result = Math.max(result, nums[i] + nums[i+1] - solve(nums, i+2, dp));
        }

        if(i+2 < nums.length){
            result = Math.max(result, nums[i] + nums[i+1] + nums[i+2] - solve(nums, i+3, dp));
        }

        return dp[i] = result;
    }
}