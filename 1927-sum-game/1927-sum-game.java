class Solution {
    public boolean sumGame(String num) {
        int n = num.length();
        
        if(num.indexOf('?') == -1){
            int i = 0;
            int j = n/2;
            int lsum = 0;
            int rsum = 0;

            while(i < n/2 && j < n){
                lsum += num.charAt(i) - '0';
                rsum += num.charAt(j) - '0';
                i++;
                j++;
            }
            if(lsum == rsum){
                return false;
            }
            else{
                return true;
            }
        }

        int lcount = 0;
        int rcount = 0;
        int i = 0;
        int j = n/2;
        int lsum = 0;
        int rsum = 0;

        while(i < n/2 && j < n){
            if(num.charAt(i) == '?') lcount++;
            else lsum += num.charAt(i) - '0';
            if(num.charAt(j) == '?') rcount++;
            else rsum += num.charAt(j) - '0';
            i++;
            j++;
        }

        if((lcount + rcount) % 2 != 0){
            return true;
        }

        int left = 2 * lsum + 9 * lcount;
        int right = 2 * rsum + 9 * rcount;

        if(left == right){
            return false;
        }

        return true;
    }
}