class Solution {
    public int largestRectangleArea(int[] heights) {
        if(heights.length == 0){
            return 0;
        }
        int n = heights.length;
        int maxArea = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        for(int i = 0; i < n; i++){
            while(!stack.isEmpty() && heights[stack.peek()] > heights[i]){
                maxArea = getmax(heights, stack, maxArea, i);
            }
            stack.push(i);
        }

        int i = heights.length;
        while(!stack.isEmpty()){
            maxArea = getmax(heights, stack, maxArea, i);
        }

        return maxArea;
    }

    private int getmax(int[] heights, Stack<Integer> stack, int maxArea, int i){
        int area = 0;
        int popped = stack.pop();
        if(stack.isEmpty()){
            area = heights[popped] * i;
        }
        else{
            area = heights[popped] * (i - stack.peek()-1);
        }

        maxArea = Math.max(maxArea, area);
        return maxArea;
    }
}