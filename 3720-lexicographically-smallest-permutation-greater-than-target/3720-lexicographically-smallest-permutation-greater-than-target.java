class Solution {
    String result = "";

    public String lexGreaterPermutation(String s, String target) {
        int[] freq = new int[26];

        for(char ch : s.toCharArray()){
            freq[ch - 'a']++;
        }

        StringBuilder curr = new StringBuilder();

        solve(curr, freq, target, 0, false);

        return result;
    }

    boolean solve(StringBuilder curr, int[] freq, String target, int i, boolean greater) {

        if(i == target.length()){
            if(greater){
                result = curr.toString();
                return true;
            }

            return false;
        }

        for(char ch = 'a'; ch <= 'z'; ch++){

            if(freq[ch - 'a'] == 0)
                continue;

            // If we are still equal to target,
            // choosing a smaller character would make
            // the entire permutation smaller.
            if(!greater && ch < target.charAt(i))
                continue;

            curr.append(ch);
            freq[ch - 'a']--;

            // Once we choose a bigger character,
            // the rest of the positions don't matter.
            boolean isGreater = greater || ch > target.charAt(i);

            if(solve(curr, freq, target, i + 1, isGreater)){
                return true;
            }

            curr.deleteCharAt(curr.length() - 1);
            freq[ch - 'a']++;
        }

        return false;
    }
}