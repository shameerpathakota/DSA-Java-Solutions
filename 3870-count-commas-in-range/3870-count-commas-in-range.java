class Solution {
    public int countCommas(int n) {
        int count = 0;
        int temp = n;
        while(n > 0){
            count++;
            n = n/10;
        }

        if(count >= 4){
            temp = temp - 1000;
            return temp+1;
        }

        return 0;
    }
}