class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        for(String s : strs){

            char[] ch = s.toCharArray();
            Arrays.sort(ch);

            String temp = new String(ch);

            map.putIfAbsent(temp, new ArrayList<>());
            map.get(temp).add(s);
        }

        return new ArrayList<>(map.values());
    }
}