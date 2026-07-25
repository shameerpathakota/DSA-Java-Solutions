/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int kthSmallest(TreeNode root, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        build(list, root);
        return list.get(k-1);
    }

    void build(ArrayList<Integer> list, TreeNode root){
        if(root == null){
            return;
        }

        build(list, root.left);
        list.add(root.val);
        build(list, root.right);
    }
}