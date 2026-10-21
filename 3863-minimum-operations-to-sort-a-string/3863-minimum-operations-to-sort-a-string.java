class Solution {
    public int minOperations(String s) {
        int n = s.length();

        char[] arr = s.toCharArray();
        boolean flag = true;

        for(int i = 1; i < n; i++){
            if(arr[i] < arr[i-1]){
                flag = false;
                break;
            }
        }

        if(flag){
            return 0;
        }

        if(n == 2){
            return -1;
        }

        char max_char = arr[0];
        char min_char = arr[0];

        for(char ch : arr){
            max_char = (char)Math.max(ch, max_char);
            min_char = (char)Math.min(min_char, ch);
        }

        //case one if either of the one present at correct position.
        if(max_char == arr[n-1] || min_char == arr[0]){
            return 1;
        }

        char Minmid = arr[1];
        char Maxmid = arr[1];

        for(int i = 2; i < n-1; i++){
            Minmid = (char)Math.min(Minmid, arr[i]);
            Maxmid = (char)Math.max(Maxmid, arr[i]);
        }

        if(arr[0] > Maxmid && arr[n-1] < Minmid){
            return 3;
        }

        return 2;
    }
}