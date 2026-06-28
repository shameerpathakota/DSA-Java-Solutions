class Solution {
    public int removeDuplicates(int[] nums) {
        int start = 0;
        int second = 1;
        while(second < nums.length){
            if(nums[start] != nums[second]){
                nums[start+1] = nums[second];
                start++;
            }
            second++;
        }

        return start + 1;
    }
}