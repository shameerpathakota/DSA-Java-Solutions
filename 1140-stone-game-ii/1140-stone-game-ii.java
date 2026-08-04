class Solution {
    int n = 0;
    public int stoneGameII(int[] piles) {
        n = piles.length;
        int[][][] dp = new int[2][101][101];
        for(int[][] arr : dp){
            for(int[] nums : arr){
                Arrays.fill(nums, -1);
            }
        }
        return solve(piles, 1, 0, 1, dp);
    }

    int solve(int[] piles, int person, int i, int M, int[][][] dp){
        if(i >= n){
            return 0;
        }

        if(dp[person][i][M] != -1){
            return dp[person][i][M];
        }

        int result = (person == 1) ? -1 : Integer.MAX_VALUE;
        int stones = 0;

        for(int x = 1; x <= Math.min(2*M, n-i); x++){
            stones += piles[i+x-1];
            if(person == 1){
                result = Math.max(result, stones + solve(piles, 0, i+x, Math.max(M, x), dp));
            }

            else{
                result = Math.min(result, solve(piles, 1, i+x, Math.max(M, x), dp));
            }
        }

        return dp[person][i][M] = result;
    }
}