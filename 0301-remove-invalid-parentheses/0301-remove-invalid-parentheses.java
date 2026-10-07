class Solution {
    HashSet<String> set = new HashSet<>();
    int max_length = 0;
    int n;
    public List<String> removeInvalidParentheses(String s) {
        n = s.length();
        set.clear();

        solve(s, 0, new StringBuilder(), 0);
        return new ArrayList<>(set);
    }

    public void solve(String s, int i, StringBuilder curr, int count){
        if(count < 0) return;

        if(i == n){
            if(count == 0){
                if(curr.length() > max_length){
                    max_length = curr.length();
                    set.clear();
                }
                if(curr.length() == max_length){
                    set.add(curr.toString());
                }
            }

            return;
        }

        char ch = s.charAt(i);

        if(ch != '(' && ch != ')'){
            curr.append(ch);
            solve(s, i+1, curr, count);
            curr.deleteCharAt(curr.length() - 1);
            return;
        }

        //Do
        curr.append(ch);

        //Explore
        solve(s, i+1, curr, count + (ch == '(' ? 1 : -1));

        //undo and explore
        curr.deleteCharAt(curr.length() - 1);
        solve(s, i+1, curr, count);
    }
}