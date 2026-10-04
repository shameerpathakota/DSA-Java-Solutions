class Solution {
    public boolean checkValidString(String s) {
        int n = s.length();
        int[][] dp = new int[n+1][n+1];

        for(int[] arr : dp){
            Arrays.fill(arr, -1);
        }

        return solve(0, 0, s, dp);
    }

    boolean solve(int i, int opencount, String s, int[][] dp){
        if(i >= s.length()){
            return opencount == 0;
        }

        if(dp[i][opencount] != -1){
            return dp[i][opencount] == 1;
        }

        boolean temp1 = false;
        boolean temp2 = false;
        boolean temp3 = false;
        boolean temp4 = false;
        boolean temp5 = false;

        if(s.charAt(i) == '('){
            temp1 = solve(i+1, opencount+1, s, dp);
        }
        else if(s.charAt(i) == '*'){
            temp2 = solve(i+1, opencount+1, s, dp);//treat the * as a open bracket.
            temp3 = solve(i+1, opencount, s, dp);// treat the * as empty one
            if(opencount > 0){
                temp4 = solve(i+1, opencount-1, s, dp);//treat the * as closed bracket
            }
        }
        else if(opencount > 0){
            temp5 = solve(i+1, opencount-1, s, dp);
        }

        boolean temp = temp1 || temp2 || temp3 || temp4 || temp5;
        dp[i][opencount] = temp == true ? 1 : 0;
        
        return temp1 || temp2 || temp3 || temp4 || temp5;
    }
}