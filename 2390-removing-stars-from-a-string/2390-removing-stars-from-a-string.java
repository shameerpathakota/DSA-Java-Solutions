class Solution {
    public String removeStars(String s) {
        Stack<Character> stack = new Stack<>();

        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if(!stack.isEmpty() && ch == '*'){
                stack.pop();
            }
            else{
                stack.push(ch);
            }
        }

        StringBuilder result = new StringBuilder();

        while(!stack.isEmpty()){
            result.append(stack.pop());
        }

        result.reverse();

        return new String(result);
    }
}