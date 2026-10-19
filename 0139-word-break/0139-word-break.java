class Solution {
    HashMap<String, Boolean> map;
    static class Node{
        Node[] children = new Node[26];
        boolean eow = false;

        public Node(){
            for(int i = 0; i < 26; i++){
                children[i] = null;
            }
        }
    }

    public  Node root = new Node();

    public void insert(String str){
        Node curr = root;
        for(int level = 0; level<str.length(); level++){
            int index = str.charAt(level) - 'a';
            if(curr.children[index] == null){
                curr.children[index] = new Node();
            }
            curr = curr.children[index];
        }
        curr.eow = true;
    }

    public boolean search(String key){
        Node curr = root;
        for(int i = 0; i < key.length(); i++){
            int index = key.charAt(i) - 'a';
            if(curr.children[index] == null){
                return false;
            }
            curr = curr.children[index];
        }

        return curr.eow == true;
    }
    public boolean wordBreak(String s, List<String> wordDict) {
        for(int i = 0; i < wordDict.size(); i++){
            insert(wordDict.get(i));
        }
        map = new HashMap<>();
        return helper(s);
    }

    public boolean helper(String s){
        if(s.length() == 0){
            return true;
        }
        if(map.containsKey(s)){
            return map.get(s);
        }
        for(int i = 1; i <= s.length(); i++){
            if(search(s.substring(0, i)) && helper(s.substring(i))){
                map.put(s, true);
                return true;
            }
        }

        map.put(s, false);
        return false;
    }
}