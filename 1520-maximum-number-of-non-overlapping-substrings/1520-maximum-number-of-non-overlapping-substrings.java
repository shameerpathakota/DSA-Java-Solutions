class Solution {
    public List<String> maxNumOfSubstrings(String s) {
        int n = s.length();
        int[] startindex = new int[26];
        int[] endindex = new int[26];
        boolean[] isValid = new boolean[26];
        Arrays.fill(startindex, -1);
        Arrays.fill(endindex, -1);
        Arrays.fill(isValid, true);

        //step 1 : store the start and end index of each character
        for(int i = 0; i < s.length(); i++){
            int index = s.charAt(i) - 'a';
            if(startindex[index] == -1){
                startindex[index] = i;
            }
            endindex[index] = i;
        }

        //step 2 : extend the ending index value and mark the invalid starting index of substrings
        for(int c = 0; c < 26; c++){
            if(startindex[c] == -1) continue;

            for(int i = startindex[c]; i < endindex[c]; i++){
                int ch = s.charAt(i) - 'a';
                if(startindex[ch] < startindex[c]){
                    isValid[c] = false;
                    break;
                }

                endindex[c] = Math.max(endindex[c], endindex[ch]);
            }
        }

        List<String> result = new ArrayList<>();

        int lasttakeindx = Integer.MAX_VALUE;
        for(int i = n-1; i >= 0; i--){
            int ch = s.charAt(i) - 'a';
            if(!isValid[ch]) continue;

            if(i == startindex[ch] && endindex[ch] < lasttakeindx){
                result.add(s.substring(i, endindex[ch]+1));
                lasttakeindx = i;
            }
        }

        return result;
    }
}