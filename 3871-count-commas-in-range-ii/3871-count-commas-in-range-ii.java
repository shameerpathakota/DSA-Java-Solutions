class Solution {
    public long countCommas(long n) {
        if(n < 1000){
            return 0;
        }

        long result = 0;
        long lower = 1000;
        int commas = 1;

        while(lower <= n){
            long upper = lower * 1000 - 1;
            if(upper > n){
                upper = n;
            }

            result += (upper - lower + 1) * commas;
            commas++;
            lower = lower * 1000;
        }

        return result;
    }
    /*
    Idea is that 
     from 1000 - 10^6-1 -> there are only one comma
     from 10^6 - 10^9-1 -> there are 2 commas
     from 10^9 - 10^12-1 -> there are 3 commas

     you can see the pattern that each level the commas are incrementing by 1 and the lower bound is gets multiplied by 10^3 and the upper bound is lower * 10^3 - 1.


    */
}