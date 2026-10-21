class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();

        int[][] dp = new int[n+1][m+1];
        for(int[] arr : dp){
            Arrays.fill(arr, -1);
        }
        return lcs(text1, text2, 0, 0, dp);
    }

    int lcs(String text1, String text2, int i, int j, int[][] dp){
        if(i == text1.length() || j == text2.length()){
            return 0;
        }

        if(dp[i][j] != -1){
            return dp[i][j];
        }

        int ans = 0;
        if(text1.charAt(i) == text2.charAt(j)){
            ans = 1 + lcs(text1, text2, i+1, j+1, dp);
        }
        else{
            ans = Math.max(lcs(text1, text2, i, j+1, dp), lcs(text1, text2, i+1, j, dp));
        }

        return dp[i][j] = ans;
    }
}
/*
Note Most important .
the rows represents text1 and columns represents the text2
and matrix is filling row wise means after completion of dp[firstRow][j] then only it will go to next row.
*/