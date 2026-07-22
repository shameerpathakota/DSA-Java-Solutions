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
    int preindex = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = inorder.length;
        return helper(preorder, inorder, 0, n-1);
    }

    TreeNode helper(int[] preorder, int[] inorder, int left, int right){
        if(left > right){
            return null;
        }

        TreeNode root = new TreeNode(preorder[preindex]);
        int index = search(inorder, left, right, preorder[preindex]);
        preindex++;
        root.left = helper(preorder, inorder, left, index-1);
        root.right = helper(preorder, inorder, index+1, right);

        return root;
    }

    int search(int[] inorder, int left, int right, int target){
        for(int i = left; i <= right; i++){
            if(inorder[i] == target){
                return i;
            }
        }

        return -1;
    }
}