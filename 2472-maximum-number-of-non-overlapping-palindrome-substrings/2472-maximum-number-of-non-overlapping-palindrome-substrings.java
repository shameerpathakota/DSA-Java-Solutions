class Solution {
    int n;

    boolean isPalindrome(String s, int i, int j){
        while(i < j){
            if(s.charAt(i) != s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }

        return true;
    }
    public int maxPalindromes(String s, int k) {
        if(k == 1) return s.length();
        n = s.length();
        int[][] dp = new int[n+1][n+1];
        for(int[] arr : dp){
            Arrays.fill(arr, -1);
        }

        return solve(s, k, 0, k-1, dp);
        
    }

    int solve(String s, int k, int i, int j, int[][] dp){
        //T.C = O(n^3)
        //S.C = O(n^2)
        if(i >= n || j >= n) return 0;
        if(dp[i][j] != -1) return dp[i][j];

        if(isPalindrome(s, i, j)){
            int take_it = 1 + solve(s, k, j+1, j+k, dp);
            int grow_it = solve(s, k, i, j+1, dp);
            int slide_it = solve(s, k, i+1, j+1, dp);

            return dp[i][j] = Math.max(take_it, Math.max(grow_it, slide_it));
        }

        int grow_it = solve(s, k, i, j+1, dp);
        int slide_it = solve(s, k, i+1, j+1, dp);

        return dp[i][j] = Math.max(grow_it, slide_it);

    }
}