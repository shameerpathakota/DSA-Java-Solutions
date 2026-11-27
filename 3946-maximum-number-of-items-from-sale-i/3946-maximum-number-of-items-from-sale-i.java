class Solution {
    public int maximumSaleItems(int[][] items, int budget) {
        int n = items.length;
        int cheapest_item = Integer.MAX_VALUE;
        int[] copies = new int[n];
        int[][] dp = new int[n+1][budget+1];
        for(int[] arr : dp){
            Arrays.fill(arr, -1);
        }

        for(int i = 0; i < items.length; i++){
            int copy = 0;
            cheapest_item = Math.min(cheapest_item, items[i][1]);
            for(int j = 0; j < items.length; j++){
                if(i == j){
                    continue;
                }

                if(items[j][0] % items[i][0] == 0){
                    copy++;
                }
            }

            copies[i] = copy;
        }

        return solve(items, budget, cheapest_item, copies, n, dp);
    }

    int solve(int[][] items, int budget, int cheapest_item, int[] copies, int n, int[][] dp){
        if(n == 0){
            return budget/cheapest_item;
        }

        if(dp[n][budget] != -1){
            return dp[n][budget];
        }

        int take = 0;
        int price = items[n-1][1];
        if(price <= budget){
            take = 1 + copies[n-1] + solve(items, budget - price, cheapest_item, copies, n-1, dp);
        }
        int skip = solve(items, budget, cheapest_item, copies, n-1, dp);

        return dp[n][budget] = Math.max(take, skip);
    }
}