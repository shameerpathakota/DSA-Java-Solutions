class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][2];
        for(int[] num : dp){
            Arrays.fill(num, -1);
        }

        return f(prices, 0, 1, dp);
    }

    int f(int[] prices, int index, int buy, int[][] dp){
        if(index == prices.length){
            return 0;
        }

        if(dp[index][buy] != -1){
            return dp[index][buy];
        }

        int profit = 0;
        if(buy == 1){
            profit = Math.max(-prices[index] + f(prices, index+1, 0, dp), 0+f(prices, index+1, 1, dp));
        }
        else{
            profit = Math.max(prices[index] + f(prices, index+1, 1, dp), 0 + f(prices, index+1, 0, dp));
        }

        return dp[index][buy] = profit;
    }
}