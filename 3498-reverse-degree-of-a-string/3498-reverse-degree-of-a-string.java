class Solution {
    public int reverseDegree(String s) {
        int[] feq = new int[26];
        int k = 26;
        for(int i = 0; i < 26; i++){
            feq[i] = k--;
        }

        int degree = 0;
        for(int i = 0; i < s.length(); i++){
            int index = s.charAt(i) - 'a';
            int d = feq[index];
            degree += (d*(i+1));
        }

        return degree;
    }
}