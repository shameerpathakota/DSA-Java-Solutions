class Solution {
    public boolean checkDivisibility(int n) {
        int ds = digitSum(n);
        int dp = digitProduct(n);
        int sum = ds + dp;
        return n % sum == 0;
    }

    int digitSum(int n){
        int ans = 0;
        while(n > 0){
            int rem = n % 10;
            ans += rem;
            n = n / 10;
        }
        return ans;
    }

    int digitProduct(int n){
        int ans = 1;
        while(n > 0){
            int rem = n % 10;
            ans *= rem;
            n = n / 10;
        }

        return ans;
    }
}