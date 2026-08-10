class Solution {
    public boolean winnerSquareGame(int n) {
       if(s(n)){
        return true;
       } 

       boolean[] dp = new boolean[n+1];
       for(int i = 1; i <= n; i++){
        for(int k = 1; k*k <= i; k++){
            if(!dp[i - k*k]){
                dp[i] = true;
                break;
            }
        }
       }

       return dp[n];
    }

    boolean s(int n){
        if(n < 0){
            return false;
        }

        int root = (int)Math.sqrt(n);
        return root * root == n;
    }
}