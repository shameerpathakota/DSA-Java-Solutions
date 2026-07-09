class Solution {
    public boolean checkInclusion(String s1, String s2) {
        char[] arr = s1.toCharArray();
        Arrays.sort(arr);
        int n = s1.length();
        int i = 0;
        int j = n;
        while(j <= s2.length()){
            char[] ch = s2.substring(i, j).toCharArray();
            Arrays.sort(ch);
            if(Arrays.equals(arr, ch)){
                return true;
            }
            j++;
            i++;
        }

        return false;
    }
}