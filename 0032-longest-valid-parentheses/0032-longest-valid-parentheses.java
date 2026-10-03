class Solution {
    public int longestValidParentheses(String s) {
        if(s.length() == 0){
            return 0;
        }
        int max_length = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '('){
                stack.push(i);
            } else {
                stack.pop();
                if(stack.isEmpty()){
                    stack.push(i);
                }
                else{
                    max_length = Math.max(max_length, i - stack.peek());
                }
            }
        }
        
        return max_length;
    }
}