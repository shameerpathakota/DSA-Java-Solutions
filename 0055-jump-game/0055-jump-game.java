class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);
        
        return solve(nums, n, 0, dp);
    }

    boolean solve(int[] nums, int n, int index, int[] dp){
        if(index == n-1){
            dp[index] = 1;
            return true;
        }

        if(dp[index] != -1){
            return dp[index] == 1;
        }
        if(index >= n){
            return false;
        }

        for(int i = 1; i <= nums[index]; i++){
            if(solve(nums, n, index+i, dp)){
                dp[index] = 1;
                return true;
            }
        }

        dp[index] = 0;
        return false;
    }
}