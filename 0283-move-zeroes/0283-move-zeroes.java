class Solution {
    public void moveZeroes(int[] nums) {
        int slow = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] != 0){
                swap(nums,slow,i);
                slow++;
            }
        }
    }
    public void swap(int[] arr, int start, int end){
        int temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;
    }
}