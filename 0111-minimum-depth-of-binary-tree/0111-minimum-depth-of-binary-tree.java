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
    public int minDepth(TreeNode root) {
        return mindepth(root);

    }

    int mindepth(TreeNode node) {
    if (node == null) {
        return 0;
    }

    if (node.left == null) {
        return mindepth(node.right) + 1;
    }

    if (node.right == null) {
        return mindepth(node.left) + 1;
    }

    int left = mindepth(node.left);
    int right = mindepth(node.right);

    return Math.min(left, right) + 1;
   }
}