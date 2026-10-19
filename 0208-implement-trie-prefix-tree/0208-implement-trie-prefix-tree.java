class Trie {
    class Node {
        Node[] children = new Node[26];
        boolean eow = false;

        Node() {
            for(int i = 0; i < 26; i++){
                children[i] = null;
            }
        }
    }

    Node root;
    public Trie() {
        root = new Node();
    }
    
    public void insert(String word) {
        Node curr = root;

        for(int i = 0; i < word.length(); i++){
            int index = word.charAt(i) - 'a';
            if(curr.children[index] == null){
                curr.children[index] = new Node();
            }
            curr = curr.children[index];
        }

        curr.eow = true;
    }
    
    public boolean search(String word) {
        Node curr = root;

        for(int i = 0; i < word.length(); i++){
            int index = word.charAt(i) - 'a';
            if(curr.children[index] == null){
                return false;
            }
            curr = curr.children[index];
        }

        return curr.eow == true;
    }
    
    public boolean startsWith(String prefix) {
        Node curr = root;
        for(int i = 0; i < prefix.length(); i++){
            int index = prefix.charAt(i) - 'a';
            if(curr.children[index] == null){
                return false;
            }
            curr = curr.children[index];
        }

        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */