class Solution {
    public int sumOfTheDigitsOfHarshadNumber(int x) {
        int sum = fun(x);
        if(x % sum == 0){
            return sum;
        }
        return -1;
    }

    int fun(int n){
        int ans = 0;
        while(n > 0){
            int rem = n % 10;
            ans += rem;
            n = n/10;
        }
        return ans;
    }
}