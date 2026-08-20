class Solution {
    public int[] applyOperations(int[] nums) {
        int n = nums.length;
        for(int i = 0; i < n-1; i++){
            if(nums[i] == nums[i+1]){
                nums[i] = nums[i]*2;
                nums[i+1] = 0;
            }
        }

        int slow = 0;
        for(int i = 0; i < n; i++){
            if(nums[i] != 0){
                swap(nums, slow, i);
                slow++;
            }
        }

        return nums;
    }
    public void swap(int[] arr, int start, int end){
        int temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;
    }
}