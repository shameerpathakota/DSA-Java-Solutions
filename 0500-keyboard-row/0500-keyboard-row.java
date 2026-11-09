class Solution {
    public String[] findWords(String[] words) {
        HashMap<Character, Integer> map = new HashMap<>();
        // int[] feq = new int[26];
        // feq[1] = 1;//b
        map.put('a', 0);
        map.put('s', 0);
        map.put('d', 0);
        map.put('f', 0);
        map.put('g', 0);
        map.put('h', 0);
        map.put('j', 0);
        map.put('k', 0);
        map.put('l', 0);
        map.put('q', 1);
        map.put('w', 1);
        map.put('e', 1);
        map.put('r', 1);
        map.put('t', 1);
        map.put('y', 1);
        map.put('u', 1);
        map.put('i', 1);
        map.put('o', 1);
        map.put('p', 1);
        map.put('z', 2);
        map.put('x', 2);
        map.put('c', 2);
        map.put('v', 2);
        map.put('b', 2);
        map.put('n', 2);
        map.put('m', 2);

        List<String> list = new ArrayList<>();
        for(String word : words){
            String temp = word.toLowerCase();
            boolean valid = true;
            for(int i = 1; i < temp.length(); i++){
                char ch1 = temp.charAt(i-1);
                char ch2 = temp.charAt(i);

                if(map.get(ch1) != map.get(ch2)){
                    valid = false;
                    break;
                }

            }

            if(valid){
                list.add(word);
            }
        }


        String[] ans = new String[list.size()];

        for(int i = 0; i < list.size(); i++){
            ans[i] = list.get(i);
        }

        return ans;


    }
}