class Solution {
    public int smallestNumber(int n, int t) {
       for(long i = n; i < Integer.MAX_VALUE; i++){
        long pro = digit_Product(i);
        if(pro == 0 || pro % t == 0){
            return (int)(i);
        }
       }

       return -1;

    }

    long digit_Product(long n){
        long ans = 1;
        while(n > 0){
            long rem = n % 10;
            ans = ans * rem;
            n = n/10;
        }

        return ans;
    }
}