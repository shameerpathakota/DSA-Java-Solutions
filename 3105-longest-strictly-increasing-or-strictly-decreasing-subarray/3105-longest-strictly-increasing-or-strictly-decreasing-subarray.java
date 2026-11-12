class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int incre = 1;
        int decre = 1;

        int result = 1;

        for(int i = 1; i < nums.length; i++){
            if(nums[i] > nums[i-1]){
                incre++;
                decre = 1;

                result = Math.max(result, incre);
            }
            else if(nums[i] < nums[i-1]){
                decre++;
                incre = 1;

                result = Math.max(result, decre);
            }
            else{
                incre = 1;
                decre = 1;
            }
        }

        return result;
    }
}