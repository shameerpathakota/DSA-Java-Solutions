class Solution {
    int n;
    public List<List<String>> partition(String s) {
        n = s.length();
        List<List<String>> result = new ArrayList<>();
        List<String> curr = new ArrayList<>();
        backtrack(s, 0, curr, result);
        return result;
    }

    void backtrack(String s, int index, List<String> curr, List<List<String>> result){
        if(index >= s.length()){
            result.add(new ArrayList<>(curr));
            return;
        }

        for(int i = index; i < n; i++){
            if(isPalindrome(s, index, i)){
                curr.add(s.substring(index, i+1));
                backtrack(s, i+1, curr, result);
                curr.remove(curr.size() - 1);
            }
        }
    }

    boolean isPalindrome(String s, int i, int j){
        while(i < j){
            if(s.charAt(i) != s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}