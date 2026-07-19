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
    TreeNode prev = null;
    int min_diff = Integer.MAX_VALUE;
    public int minDiffInBST(TreeNode root) {
        inorder(root);
        return min_diff;
    }

    void inorder(TreeNode root){
        if(root == null){
            return;
        }

        inorder(root.left);
        if(prev != null){
            min_diff = Math.min(min_diff, root.val-prev.val);
        }
        prev = root;
        inorder(root.right);
    }
}