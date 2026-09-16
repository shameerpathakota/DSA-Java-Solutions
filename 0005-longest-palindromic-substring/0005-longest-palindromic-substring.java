class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        int low = 0;
        int high = 0;
        String result = "";

        for(int i = 0; i < n; i++){
            low = i;
            high = i;

            while(low >= 0 && high < n && s.charAt(low) == s.charAt(high)){//for odd length substring
                low--;
                high++;
            }

            String temp = s.substring(low+1, high);
            if(temp.length() > result.length()){
                result = temp;
            }

            low = i;
            high = i+1;

            while(low >= 0 && high < n && s.charAt(low) == s.charAt(high)){//for even length substring
                low--;
                high++;
            }

            temp = s.substring(low+1, high);
            if(temp.length() > result.length()){
                result = temp;
            }

        }

        return result;
    }
}