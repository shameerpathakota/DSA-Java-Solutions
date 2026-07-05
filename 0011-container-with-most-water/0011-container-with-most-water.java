class Solution {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length-1;
        int max_area = Integer.MIN_VALUE;
        while(left < right){
            int Height = Math.min(height[left], height[right]);
            int width = right - left;
            int area = Height * width;
            max_area = Math.max(max_area, area);
            if(height[left] < height[right]){
                left++;
            }
            else{
                right--;
            }
        }

        return max_area;
    }
}