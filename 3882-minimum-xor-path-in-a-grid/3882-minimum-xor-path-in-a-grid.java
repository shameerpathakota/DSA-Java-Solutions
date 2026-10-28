class Solution {
    public int minCost(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        BitSet[][] dp = new BitSet[m][n];
        for(int i = 0; i < m; i++){
            for(int j= 0; j < n; j++){
                dp[i][j] = new BitSet();
            }
        }

        dp[0][0].set(grid[0][0]);
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(i == 0 && j == 0){
                    continue;
                }

                BitSet up = new BitSet();
                BitSet left = new BitSet();

                if(i > 0){
                    up = (BitSet) dp[i-1][j].clone();
                }
                if(j > 0){
                    left = (BitSet) dp[i][j-1].clone();
                }

                BitSet combined = new BitSet();
                combined = (BitSet) up.clone();
                combined.or(left);

                for(int xorvalue = 0; xorvalue < 1024; xorvalue++){
                    if(combined.get(xorvalue)){
                        int resultxor = xorvalue ^ grid[i][j];
                        dp[i][j].set(resultxor);
                    }
                }
            }
        }

        for(int xorvalue = 0; xorvalue < 1024; xorvalue++){
            if(dp[m-1][n-1].get(xorvalue)){
                return xorvalue;
            }
        }

        return -1;
    }
}