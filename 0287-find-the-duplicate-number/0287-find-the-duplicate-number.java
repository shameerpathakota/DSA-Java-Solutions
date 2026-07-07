class Solution {
    public int findDuplicate(int[] nums) {
        int n = nums.length;
        int i = 0;
        while(i < n){
            int correct = nums[i] - 1;
            if(nums[i] != nums[correct]){
                swap(nums, i, correct);
            }
            else{
                i++;
            }
        }

        for(int index = 0; index < n; index++){
            if(nums[index] != index+1){
                return nums[index];
            }
        }

        return -1;
    }

    void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}