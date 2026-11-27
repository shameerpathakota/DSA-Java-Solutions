class Solution {
    public static int minimumAverageDifference(int[] nums) {
        int n = nums.length;

        long[] prefix_sum = new long[n];
        prefix_sum[0] = nums[0];

        for(int i = 1; i < n; i++){
            prefix_sum[i] = prefix_sum[i-1] + nums[i];
        }

        long min_diff = Integer.MAX_VALUE;
        int ans = -1;

        for(int i = 0; i < n; i++){
            long avg1 = prefix_sum[i] / (i+1);
            long avg2 = 0;
            if(i == n-1){
                avg2 = 0;
            }
            else{
                avg2 = (prefix_sum[n-1] - prefix_sum[i]) / (n-i-1);
            }


            if(Math.abs(avg1 - avg2) < min_diff){
                min_diff = Math.abs(avg1 - avg2);
                ans = i;
            }
        }

        return ans;

    }
}