class Solution {
    int count = 0;
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

    public void insert(String s){
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

    void findCommon(Node node){
        if(node == null){
            return;
        }

        Node curr = node;
        if(curr.eow){
            return;
        }

        Node temp = null;
        int times = 0;

        for(int i = 0; i < 26; i++){
            if(curr.children[i] != null){
                temp = curr.children[i];
                times++;
            }
        }

        if(times > 1){
            return;
        }

        else if(times == 1){
            count++;
            findCommon(temp);
        }
    }
    public String longestCommonPrefix(String[] strs) {
        for(String s : strs){
            insert(s);
        }
        
        findCommon(root);

        if(count == 0) return "";

        return strs[0].substring(0, count);
    }
}