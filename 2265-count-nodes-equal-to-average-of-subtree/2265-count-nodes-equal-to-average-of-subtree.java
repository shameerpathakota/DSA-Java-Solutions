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
    int result;
    class Pair{
        int value;
        int count;

        public Pair(int value, int count){
            this.value = value;
            this.count = count;
        }
    }
    public int averageOfSubtree(TreeNode root) {
        result = 0;
        solve(root);
        return result;
    }

    Pair solve(TreeNode node){
        if(node == null){
            return new Pair(0, 0);
        }

        Pair leftsub = solve(node.left);
        Pair rightsub = solve(node.right);

        int sum = leftsub.value + rightsub.value + node.val;
        int number_of_nodes = leftsub.count + rightsub.count + 1;

        if(sum / number_of_nodes == node.val){
            result++;
        }

        return new Pair(sum, number_of_nodes);
    }
}