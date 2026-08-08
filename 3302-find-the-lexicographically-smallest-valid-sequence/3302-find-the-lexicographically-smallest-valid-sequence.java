class Solution {
    public int[] validSequence(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();

        int[] rightHandSideMatched = new int[n];

        int i = n-1;
        int j = m-1;
        int rightSideMatched = 0;

        while(i >= 0){
            if(j >= 0 && word1.charAt(i) == word2.charAt(j)){
                rightSideMatched++;
                j--;
            }

            rightHandSideMatched[i] = rightSideMatched;
            i--;
        }

        int[] seq = new int[m];
        boolean canChangePower = true;

        i = 0;
        j = 0;
        int index = 0;

        while(i < n && j < m){
            if(word1.charAt(i) == word2.charAt(j)){
                seq[index] = i;
                j++;
                index++;
            }
            else if(canChangePower == true && i < n-1 && rightHandSideMatched[i+1] >= m-j-1){
                seq[index] = i;
                j++;
                index++;
                canChangePower = false;
            }
            i++;
        }

        return j == m ? seq : new int[]{};
    }
}