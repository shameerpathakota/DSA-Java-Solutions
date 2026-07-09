class Solution {
    public String reverseWords(String s) {
        String cleaned = s.trim().replaceAll(" +", " ");
        char[] arr = cleaned.toCharArray();
        int n = arr.length;
        reverse(arr, 0, n-1);
        int i = 0;
        int j = 0;
        while(j < n){
            if(arr[j] == ' '){
                reverse(arr, i, j-1);
                i = j + 1;
            }
            else if(j == n-1){
                reverse(arr, i, j);
            }
            j++;
        }
        return (new String(arr));
    }

    void reverse(char[] arr, int i, int j){
        while(i <= j){
            char temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }
}