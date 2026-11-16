class Solution {
    public String digitSum(String s, int k) {
        int n = s.length();

        while(n > k){
            s = solve(s, k);
            n = s.length();
        }

        return s;
    }

    String solve(String s, int k){
        String ans = "";

        for(int i = 0; i < s.length(); i += k){
            int j = i;
            int count = 0;
            int temp = 0;
            while(j < s.length() && count < k){
                temp += s.charAt(j) - '0';
                j++;
                count++;
            }

            ans += temp;
        }

        return ans;
    }
}