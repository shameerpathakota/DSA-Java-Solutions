class Solution {
    public int minMoves(int[] nums) {
        int n = nums.length;

        int min = Integer.MAX_VALUE;

        //find the min element.
        for(int i = 0; i < n; i++){
            if(nums[i] < min){
                min = nums[i];
            }
        }

        int moves = 0;

        for(int i = 0; i < n; i++){
            moves += (nums[i] - min);
        }

        return moves;
    }
}