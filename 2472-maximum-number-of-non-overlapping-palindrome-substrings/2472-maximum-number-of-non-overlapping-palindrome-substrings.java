class Solution {
    int n;
    boolean[][] isPalindrome;

    // boolean isPalindrome(String s, int i, int j){
    //     while(i < j){
    //         if(s.charAt(i) != s.charAt(j)){
    //             return false;
    //         }
    //         i++;
    //         j--;
    //     }

    //     return true;
    // }
    public int maxPalindromes(String s, int k) {
        if(k == 1) return s.length();
        n = s.length();
        isPalindrome = new boolean[n+1][n+1];
        for(int L = 1; L <= n; L++){
            for(int i = 0; i + L <= n; i++){
                int j = L + i - 1;
                if(i == j) isPalindrome[i][j] = true;//means substring of length 1
                else if(i+1 == j) isPalindrome[i][j] = (s.charAt(i) == s.charAt(j));
                else isPalindrome[i][j] = (s.charAt(i) == s.charAt(j)) && isPalindrome[i+1][j-1];
            }
        }
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

        if(isPalindrome[i][j]){
            int take_it = 1 + solve(s, k, j+1, j+k, dp);
            int grow_it = solve(s, k, i, j+1, dp);
            int slide_it = solve(s, k, i+1, j+1, dp);

            return dp[i][j] = Math.max(take_it, Math.max(grow_it, slide_it));
        }

        int grow_it = solve(s, k, i, j+1, dp);
        int slide_it = solve(s, k, i+1, j+1, dp);

        return dp[i][j] = Math.max(grow_it, slide_it);

    }
    /*we can optimize the time complexity of O(n) for checking each time whether a substring is palindrome or not*/
}