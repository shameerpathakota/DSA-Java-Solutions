class Solution {
    public static int compress(char[] chars) {
        int n = chars.length;
        if(n == 1){
            return 1;
        }
        StringBuilder s = new StringBuilder();
        int i = 0;
        int j = 0;
        while(j < n-1){
            if(chars[j] != chars[j+1]){
                if(j-i+1 != 1){
                    int count = j-i+1;
                    char ch = chars[i];
                    s.append(ch).append(count);
                    i = j+1;
                }
                else{
                    s.append(chars[i]);
                    i = j + 1;
                }
            }
            j++;
        }
        if(j <= n-1){
            if(j-i+1 != 1){
                s.append(chars[i]).append(j-i+1);
            }
            else{
                s.append(chars[i]);
            }
        }
        char[] dummy = s.toString().toCharArray();
        for(int k = 0; k < dummy.length; k++){
            chars[k] = dummy[k];
        }
        return s.length();
    }
}