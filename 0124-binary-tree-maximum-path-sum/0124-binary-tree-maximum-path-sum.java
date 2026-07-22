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
    int max_sum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        dfs(root);
        return max_sum;
    }

    public int dfs(TreeNode root){
        if(root == null){
            return 0;
        }

        int left = Math.max(0, dfs(root.left));
        int right = Math.max(0, dfs(root.right));

        max_sum = Math.max(max_sum, left + right + root.val);

        return root.val + Math.max(left, right);
    }
}

/* refer strivers trees playlist lecture 17 -> 13:25 time line for the doubt why i am doing Math.max(0, dfs(root.left) and Math.max(0, dfs(root.right) 
*/