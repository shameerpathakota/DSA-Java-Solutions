class Solution {
    int M = 1000000007;
    public int numOfSubarrays(int[] arr) {
        int n = arr.length;

        int count = 0;
        int odd = 0;
        int even = 1;
        int sum = 0;

        for(int i = 0; i < n; i++){
            sum += arr[i];
            if(sum % 2 == 0){
                //we got an even sum, so we need to check for the how many odd sum pehley dhek chukey hai.
                count = (count + odd) % M;
                even++;
            }
            else{
                //we got an odd sum, so we need to check for the how many even sum pehley dhek chukey hai.
                count = (count + even) % M;
                odd++;
            }
        }

        return count;

    }
}