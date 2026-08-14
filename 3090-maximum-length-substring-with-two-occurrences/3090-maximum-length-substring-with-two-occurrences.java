class Solution {
    public int maximumLengthSubstring(String s) {
        int l = 0;
        int r = 0;
        int max_length = 0;
        
        HashMap<Character, Integer> map = new HashMap<>();
        while(r < s.length()){
            char ch = s.charAt(r);
            map.put(ch, map.getOrDefault(ch, 0)+1);
            while(map.get(ch) > 2 && l <= r){
                char c = s.charAt(l);
                map.put(c, map.getOrDefault(c, 0) - 1);
                l++;
            }
            max_length = Math.max(max_length, r-l+1);
            r++;
        }

        return max_length;
    }
}