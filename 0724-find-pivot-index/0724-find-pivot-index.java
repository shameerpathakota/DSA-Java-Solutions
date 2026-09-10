class Solution {
    public int pivotIndex(int[] nums) {
        int n = nums.length;
        int[] leftsum = new int[n];
        int[] rightsum = new int[n];
       
       leftsum[0] = nums[0];
       rightsum[n-1] = nums[n-1];

       for(int i = 1; i < n; i++){
        leftsum[i] = leftsum[i-1] + nums[i];
       }
       //{1, 8, 11, 17, 22, 28}

       for(int i = n-2; i >= 0; i--){
        rightsum[i] = rightsum[i+1] + nums[i];
       }
       //{28, 27, 20, 17, 11, 6}

       for(int i = 0; i < n; i++){
            if(leftsum[i] == rightsum[i]){
                return i;
            }   
        }

        return -1;
    }
}