class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] freqs1 = new int[26];
        int[] freqs2 = new int[26];

        int n = s1.length();

        for(int i = 0; i < s1.length(); i++){
            freqs1[s1.charAt(i) - 'a']++;
        }

        int i = 0;
        for(int j = 0; j < s2.length(); j++){
            freqs2[s2.charAt(j) - 'a']++;
            if(j-i+1 > n){
                freqs2[s2.charAt(i) - 'a']--;
                i++;
            }

            if(Arrays.equals(freqs1, freqs2)){
                return true;
            }
        }

        return false;
    }
}