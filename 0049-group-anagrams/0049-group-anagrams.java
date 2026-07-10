class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        if(strs.length == 0){
            return result;
        }

        HashMap<String, List<String>> map = new HashMap<>();

        for(int i = 0; i < strs.length; i++){
            String temp = getstr(strs[i]);
            if(!map.isEmpty() && map.containsKey(temp)){
                map.get(temp).add(strs[i]);
            }
            else{
                List<String> list = new ArrayList<>();
                list.add(strs[i]);
                map.put(temp, list);
            }
        }

        for(List<String> ans : map.values()){
            result.add(ans);
        }

        return result;
        
    }

    static String getstr(String str){
        int[] freq = new int[26];
        int n = str.length();
        for(int i = 0; i < n; i++){
            freq[str.charAt(i) - 'a']++;
        }

        StringBuilder result = new StringBuilder();
        for(int i = 0; i < 26; i++){
            result.append("#");
            result.append(freq[i]);
        }

        return result.toString();
    }
}