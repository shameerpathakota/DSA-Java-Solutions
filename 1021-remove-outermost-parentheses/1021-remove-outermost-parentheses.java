class Solution {
    public String removeOuterParentheses(String s) {
        StringBuilder res = new StringBuilder();
        int count = 0;
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if(ch == '('){
                if(count != 0){
                    res.append(ch);
                }
                count++;
            }
            else{
                count--;
                if(count != 0){
                    res.append(ch);
                }
            }
        }

        return res.toString();
    }
}