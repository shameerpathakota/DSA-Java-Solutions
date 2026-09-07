class Solution {
    int M = 1000000007;
    int[] dp;
    int[] prev; //prev[n] = last time when we saw this nth character (1-based indexing)
    public int distinctSubseqII(String s) {
        int n = s.length();
        dp = new int[n+1];
        prev = new int[n+1];
        Arrays.fill(dp, -1);
        int[] lastseen = new int[26];
        for(int i = 1; i <= n; i++){
            int index = s.charAt(i-1) - 'a';
            prev[i] = lastseen[index];
            lastseen[index] = i;
        }
        return (solve(n) - 1 + M)%M;
    }

    int solve(int n){
        if(n == 0){
            return 1;
        }

        if(dp[n] != -1){
            return dp[n];
        }

        int total = (int)(2L * solve(n-1) % M);

        if(prev[n] != 0){
            int duplicates = solve(prev[n] - 1);
            total = (total - duplicates + M) % M;
        }

        return dp[n] = total;
    }
}