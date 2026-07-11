class Solution {
    int count = 0;
    class Node{
        Node[] children = new Node[26];
        boolean eow = false;

        public Node(){
            for(int i = 0; i < 26; i++){
                children[i] = null;
            }
        }
    }

    public Node root = new Node();

    public void insert(String str){
        Node curr = root;
        for(int i = 0; i < str.length(); i++){
            int index = str.charAt(i) - 'a';
            if(curr.children[index] == null){
                curr.children[index] = new Node();
            }
            curr = curr.children[index];
        }
        curr.eow = true;
    }

    public void findCommon(Node root){
        if(root == null){
            return;
        }
        Node curr = root;
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

        for(int i = 0; i < strs.length; i++){
            insert(strs[i]);
        }

        findCommon(root);   

        if(count == 0){
            return "";
        }

        return strs[0].substring(0, count);
    }
}