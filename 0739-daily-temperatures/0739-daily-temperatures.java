class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] ans = new int[n];
        Stack<Integer> stack = new Stack<>();
        stack.push(n-1);
        Arrays.fill(ans, 0);
        for(int i = n - 2; i >= 0; i--){
            if(temperatures[stack.peek()] > temperatures[i]){
                ans[i] = stack.peek() - i;
                stack.push(i);
            }

            else{
                
                while(!stack.isEmpty()){
                    stack.pop();
                    if(!stack.isEmpty() && temperatures[stack.peek()] > temperatures[i]){
                        ans[i] = stack.peek() - i;
                        stack.push(i);
                        break;
                    }
                }
            }

            if(stack.isEmpty()){
                stack.push(i);
            }
        }

        return ans;
    }
}