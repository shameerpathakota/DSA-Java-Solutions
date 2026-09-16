class Solution {
    int[][] dp;
    //0 means false. 1 means true, -1 means not compute yet
    public int countSubstrings(String s) {
        int n = s.length();
        dp = new int[n+1][n+1];
        for(int[] arr : dp){
            Arrays.fill(arr, -1);
        }
        int count = 0;
        for(int i = 0; i < n; i++){
            for(int j = i; j < n; j++){
                if(check(i, j, s)) count++;
            }
        }

        return count;
    }

    boolean check(int i, int j, String s){
        if(i > j){
            return true;
        } 
        
        if(dp[i][j] != -1){
            return dp[i][j] == 1;
        }

        if(s.charAt(i) == s.charAt(j)){
            boolean value = check(i+1, j-1, s);
            if(value){
                dp[i][j] = 1;
            }
            else{
                dp[i][j] = 0;
            }
            return value;
        } 

        dp[i][j] = 0;
        return false;
    }
}