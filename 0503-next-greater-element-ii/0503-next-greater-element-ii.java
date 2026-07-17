class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        
        Stack<Integer> stack = new Stack<>();
        
        Arrays.fill(ans, -1);
        
        stack.push(nums[n-1]);
        
        for(int i = n - 2; i >= 0; i--){
            if(nums[i] < stack.peek()){
                ans[i] = stack.peek();
                stack.push(nums[i]);
            }
            
            else{
                
                //boolean flag = false;
                while(!stack.isEmpty()){
                    stack.pop();
                    if(!stack.isEmpty() && nums[i] < stack.peek()){
                       // flag = true;
                        ans[i] = stack.peek();
                        stack.push(nums[i]);
                        break;
                        // if(flag == true){
                        //     break;
                        // }
                    }
                }
            }
            
            if(stack.isEmpty()){
                stack.push(nums[i]);
            }
        }

        for(int i = n-1; i >= 0; i--){
            if(nums[i] < stack.peek()){
                ans[i] = stack.peek();
                stack.push(nums[i]);
            }
            else{

                while(!stack.isEmpty()){
                    stack.pop();
                    if(!stack.isEmpty() && nums[i] < stack.peek()){
                        ans[i] = stack.peek();
                        stack.push(nums[i]);
                        break;
                    }
                }

            }
            
            if(stack.isEmpty()){
                stack.push(nums[i]);
            }

        }

        return ans;
    }
}