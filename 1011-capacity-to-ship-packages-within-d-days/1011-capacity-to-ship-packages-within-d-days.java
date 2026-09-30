class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int low = 0;
        int high = 0;

        for(int num : weights){
            low = Math.max(num, low);
            high += num;
        }

        int ans = 0;
        while(low <= high){
            int cap = low + (high - low)/2;
            if(canShip(weights, cap, days)){
                ans = cap;
                high = cap - 1;
            }
            else{
                low = cap + 1;
            }
        }

        return ans;
    }

    boolean canShip(int[] weights, int cap, int days){
        int day = 1;
        int sum = 0;
        for(int w : weights){
            if(sum + w > cap){
                day++;
                sum = w;
            }
            else{
                sum += w;
            }
        }

        return day <= days;
    }
}