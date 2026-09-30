class Solution {
    public int minSpeedOnTime(int[] dist, double hour) {
        int low = 1;
        int high = 10000000;//this is because, its not an continous trip we have to wait for nxt hour to depature.

        int ans = -1;

        while(low <= high){
            int minspeed = low + (high - low)/2;
            if(canArrive(dist, minspeed, hour)){
                ans = minspeed;
                high = minspeed - 1;
            }
            else{
                low = minspeed + 1;
            }
        }

        return ans;
    }

    boolean canArrive(int[] dist, int minspeed, double hours){
        int n = dist.length;
        double time = 0;
        for(int i = 0; i < n-1; i++){
            time += Math.ceil((double) dist[i]/minspeed);
        }

        time += (double) dist[n-1]/minspeed;

        return time <= hours;

    /* 1. Convert distance to double to avoid integer division and preserve decimal travel time.
           Example: 5 / 2 = 2, but (double)5 / 2 = 2.5.*/
    /*2. For every trip except the last, use ceil() because the next trip can start only at an integer hour.
          The last trip doesn't need ceil() because we finish the journey after it.*/
    }
}