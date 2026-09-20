class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int n = s1.length();

        int[] feq1 = new int[26];
        int[] feq2 = new int[26];

        for(int i = 0; i < n; i++){
            feq1[s1.charAt(i) - 'a']++;
        }

        int i = 0;
        for(int j = 0; j < s2.length(); j++){
            feq2[s2.charAt(j) - 'a']++;
            
            if(j-i+1 > n){
                feq2[s2.charAt(i) - 'a']--;
                i++;
            }

            if(Arrays.equals(feq1, feq2)){
                return true;
            }
        }


        return false;
    }
}