class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();

        HashMap<Character, String> map = new HashMap<>();

        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");

        solve(digits, 0, new StringBuilder(), map, result);
        return result;
    }

    void solve(String s, int index, StringBuilder temp, HashMap<Character, String> map, List<String> result){
        if(index >= s.length()){
            result.add(temp.toString());
            return;
        }

        char ch = s.charAt(index);
        String str = map.get(ch);

        for(int i = 0; i < str.length(); i++){
            temp.append(str.charAt(i));
            solve(s, index+1, temp, map, result);
            temp.deleteCharAt(temp.length()-1);
        }
    }
}

//codeStoryWithMIK
