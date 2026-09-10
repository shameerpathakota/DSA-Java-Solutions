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
    HashMap<TreeNode, Integer> map;
    int result;
    public int averageOfSubtree(TreeNode root) {
        map = new HashMap<>();
        result = 0;
        count(root);
        solve(root);
        return result;
    }

    int count(TreeNode node){
        if(node == null){
            return 0;
        }

        int lcount = count(node.left);
        int rcount = count(node.right);

        map.put(node, lcount+rcount+1);
        return lcount+rcount+1;
    }

    int solve(TreeNode node){
        if(node == null){
            return 0;
        }

        int lsum = solve(node.left);
        int rsum = solve(node.right);

        int avg = lsum+rsum+node.val;

        if(Math.round(avg/map.get(node)) == node.val){
            result++;
        }

        return avg;
    }
    
}