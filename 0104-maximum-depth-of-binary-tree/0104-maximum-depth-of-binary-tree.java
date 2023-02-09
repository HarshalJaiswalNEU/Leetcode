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
    public int maxDepth(TreeNode root) {
        
        return maxDepth( root, 0);
    }

    public int maxDepth(TreeNode root, int i){

        if( root == null) return i;

        return Math.max( maxDepth( root.left, i+1), maxDepth( root.right, i+1));
    }
}