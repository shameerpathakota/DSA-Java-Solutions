class Solution {
    public int minChanges(String s) {
        int count = 0;
        int n = s.length();

        int changes = 0;
        for(int i = 0; i < n; i += 2){
            if(s.charAt(i) == s.charAt(i+1)){
                continue;
            }
            else{
                changes++;
            }
        }

        return changes;
    }
}