class Solution {
    public int minMoves(int[] nums) {
        int n = nums.length;
        int min = Integer.MAX_VALUE;
        int sum = 0;

        for(int num : nums){
            if(num < min){
                min = num;
            }
            sum += num;
        }

        return sum - (n*min);
    }
}