class Solution {
    String ans = "";

    class Node {
        Node[] children = new Node[26];
        boolean eow = false;

        Node(){
            for(int i = 0; i < 26; i++){
                children[i] = null;
            }
        }
    }

    public Node root = new Node();

    void insert(String s){
        Node curr = root;

        for(int i = 0; i < s.length(); i++){
            int index = s.charAt(i) - 'a';
            if(curr.children[index] == null){
                curr.children[index] = new Node();
            }
            curr = curr.children[index];
        }

        curr.eow = true;
    }

    public String longestWord(String[] words) {
        for(String s : words){
            insert(s);
        }

        solve(root, new StringBuilder(""));
        return ans;
    }

    void solve(Node root, StringBuilder temp){
        if(root == null){
            return;
        }

        for(int i = 0; i < 26; i++){
            if(root.children[i] != null && root.children[i].eow == true){
                char ch = (char)(i + 'a');
                temp.append(ch);
                if(temp.length() > ans.length()){
                    ans = temp.toString();
                }
                solve(root.children[i], temp);
                temp.deleteCharAt(temp.length() - 1);
            }
        }
    }
}