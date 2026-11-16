class Solution {
    public String digitSum(String s, int k) {
        while(s.length() > k){
            String nxt = "";

            int n = s.length();
            for(int i = 0; i < n; i += k){
                int sum = 0;
                for(int j = i; j < Math.min(i+k, n); j++){
                    sum += s.charAt(j) - '0';
                }
                nxt += String.valueOf(sum);
            }

            s = nxt;
        }

        return s;
    }
}