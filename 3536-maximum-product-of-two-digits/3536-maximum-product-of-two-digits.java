class Solution {
    public int maxProduct(int n) {
        String s = String.valueOf(n);
        char[] ch = s.toCharArray();
        Arrays.sort(ch);
        String str = new String(ch);
        int len = str.length();
        int a = Character.getNumericValue(str.charAt(len-1));
        int b = Character.getNumericValue(str.charAt(len-2));
        return a*b;
    }
}