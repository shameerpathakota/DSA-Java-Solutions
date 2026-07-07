class Solution {
    public long sumAndMultiply(int n) {
        String str = String.valueOf(n);
        long m = 0;
        long sum = 0;
        for(int i = 0; i < str.length(); i++){
            char ch = str.charAt(i);
            int digit = ch - '0';
            if(digit > 0){
                sum += digit;
                m = (m * 10) + digit;
            }
        }
        return m * sum;
    }

}