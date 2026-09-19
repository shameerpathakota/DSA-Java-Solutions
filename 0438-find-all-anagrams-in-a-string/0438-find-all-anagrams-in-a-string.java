class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        if(s.length() < p.length()){
            return new ArrayList<>();
        }

        int[] smap = new int[26];
        int[] pmap = new int[26];

        for(char ch : p.toCharArray()){
            pmap[ch - 'a']++;
        }

        List<Integer> result = new ArrayList<>();

        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            smap[ch - 'a']++;

            if(i >= p.length()){
                smap[s.charAt(i - p.length()) - 'a']--;
            }

            if(Arrays.equals(smap, pmap)){
                result.add(i - p.length() + 1);
            }

            
        }

        return result;
    }
}