class Solution {
    public int minLength(String s) {
        Stack<Character> stack = new Stack<>();

        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) != 'B' && s.charAt(i) != 'D'){
                stack.push(s.charAt(i));
            }
            else{
                if(s.charAt(i) == 'B'){
                    if(!stack.isEmpty() && stack.peek() == 'A'){
                        stack.pop();
                    }
                    else{
                        stack.push(s.charAt(i));
                    }
                }

                else if (s.charAt(i) == 'D'){
                    if(!stack.isEmpty() && stack.peek() == 'C'){
                        stack.pop();
                    }
                    else{
                        stack.push(s.charAt(i));
                    }
                }
            }
        }

        return stack.size();
    }
}