class Solution {
    public int smallestNumber(int n, int t) {
        int i = n;
        while(true){
            int product = digit_Product(i);
            if(product == 0 || product % t == 0){
                return i;
            }
            i++;
        }
    }

    int digit_Product(int n){
        int ans = 1;
        while(n > 0){
            int rem = n % 10;
            ans = ans * rem;
            n = n/10;
        }

        return ans;
    }
}