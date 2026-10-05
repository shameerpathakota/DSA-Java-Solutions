class Solution {
    public int calculate(String s) {
        int n = s.length();

        Stack<Integer> stack = new Stack<>();
        int number = 0;
        int result = 0;
        int sign = 1;

        for(int i = 0; i < n; i++){
            char ch = s.charAt(i);
            if(Character.isDigit(ch)){
                number = number*10 + ch - '0';
            }
            else if(ch == '+'){
                result += (sign*number);
                number = 0;
                sign = 1;
            }
            else if(ch == '-'){
                result += (sign*number);
                number = 0;
                sign = -1;
            }
            else if(ch == '('){
                stack.push(result);
                stack.push(sign);
                result = 0;
                sign = 1;
                number = 0;
            }
            else if(ch == ')'){
                result += (sign*number);
                int top = stack.pop();
                result = result*top;
                top = stack.pop();
                result = (result + top);
                number = 0;
            }
        }

        result += (sign*number);
        return result;
    }
}