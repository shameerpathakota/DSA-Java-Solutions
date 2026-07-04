class Solution {
    public double myPow(double x, int n) {
        //base case
        long N = n;
        if(n < 0){
            x = 1/x;
            N = -N;
        }
        return helper(x, n);
    }

    static double helper(double x, long n){
        if(n == 0){
            return 1;
        }

        double half = helper(x, n/2);

        double halfsquare = half * half;
        if(n % 2 != 0){
            halfsquare = x * halfsquare;
        }

        return halfsquare;
    }
}