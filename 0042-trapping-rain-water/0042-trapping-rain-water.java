class Solution {
    public int trap(int[] height) {
        if(height.length == 0){
            return 0;
        }

        int n = height.length;

        //calculate the leftmax of each element
        int[] leftmax = new int[n];
        leftmax[0] = height[0];
        //calculate the rightmax of each element
        int[] rightmax = new int[n];
        rightmax[n-1] = height[n-1];

        //populate the leftmax and rigthmax arrays
        for(int i = 1; i < n; i++){
            leftmax[i] = Math.max(leftmax[i-1], height[i]);
        }
        for(int i = n-2; i >= 0; i--){
            rightmax[i] = Math.max(rightmax[i+1], height[i]);
        }

        int total = 0;
        for(int i = 0; i < n; i++){
            total += (Math.min(leftmax[i], rightmax[i]) - height[i]);
        }

        return total;
    }
}