class Solution {
    public int longestPalindrome(String s) {
        int longest = 0;
        boolean oddLengthPalindrome = false;
        int[] freq = new int[128];
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            freq[ch]++;
        }

        for(int count : freq){
            if(count % 2 == 0){
                longest += count;
            }
            else{
                longest += count-1;
                oddLengthPalindrome = true;

            }
        }

        if(oddLengthPalindrome){
            return longest+1;
        }

        return longest;
    }
}