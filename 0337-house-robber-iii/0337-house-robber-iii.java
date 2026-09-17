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
    HashMap<TreeNode, Integer> dp;
    public int rob(TreeNode root) {
        dp = new HashMap<>();
        return solve(root);
    }

    int solve(TreeNode node){
        if(node == null){
            return 0;
        }

        if(dp.containsKey(node)){
            return dp.get(node);
        }

        int notTake = solve(node.left) + solve(node.right);
        int take = node.val;
        if(node.left != null){
            take += solve(node.left.left) + solve(node.left.right);
        }
        if(node.right != null){
            take += solve(node.right.left) + solve(node.right.right);
        }

        int ans = Math.max(notTake, take);
        dp.put(node, ans);
        return ans;
    }
}