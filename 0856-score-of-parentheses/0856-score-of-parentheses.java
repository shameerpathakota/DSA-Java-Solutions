class Solution {
    public int scoreOfParentheses(String s) {
        int n = s.length();

        Stack<Integer> stack = new Stack<>();
        stack.push(0);

        for(int i = 0; i < n; i++){
            if(s.charAt(i) == '('){
                stack.push(0);
            }
            else{
                int val = stack.pop();
                int score = Math.max(2*val, 1);
                stack.push(score+stack.pop());
            }
        }

        return stack.peek();
    }
}
/* The main idea is that, the top value of the stack represents the current parenthese score and the second top value represents the score before the current parentheses.
Initially we are putting 0 beecause the score before the first parenthese is 0.
*/
