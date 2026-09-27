class Solution {
    public String reverseParentheses(String s) {
        int n = s.length();
        Stack<Character> stack = new Stack<>();
        int i = 0;
        StringBuilder ans = new StringBuilder();

        while(i < n){
            char ch = s.charAt(i);
            if(ch != ')'){
                stack.push(ch);
            }
            else{
                StringBuilder temp = new StringBuilder();
                while(!stack.isEmpty()){
                    char ch2 = stack.pop();
                    if(ch2 == '('){
                        if(!stack.isEmpty()){
                            for(char c : temp.toString().toCharArray()){
                                stack.push(c);
                            }
                            break;
                        }
                        else if(stack.isEmpty()){
                            ans.append(temp);
                            break;
                        }
                    }
                    temp.append(ch2);
                }
            }
            i++;
        }

        if(!stack.isEmpty()){
            StringBuilder temp = new StringBuilder();
            while(!stack.isEmpty()){
                temp.append(stack.pop());
            }
            ans.append(temp.reverse());
        }

        return ans.toString();
    }
}