class Solution {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int l = 0;
        int r = nums.length-1;

        int mid = l + (r - l)/2;
        int median = nums[mid];

        int moves = 0;
        for(int i = 0; i < nums.length; i++){
            moves += Math.abs(median-nums[i]);
        }

        return moves;
    }
}