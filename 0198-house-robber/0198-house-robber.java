class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        return fun(0, nums, dp);
    }

    int fun(int i, int[] nums, int[] dp){
        if(i == nums.length-1){
            return nums[i];
        }
        if(i >= nums.length){
            return 0;
        }
        if(dp[i] != -1){
            return dp[i];
        }

        int take = nums[i] + fun(i+2, nums, dp);
        int not_take = fun(i+1, nums, dp);

        return dp[i] = Math.max(take, not_take);
    }
}