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
    public boolean isBalanced(TreeNode root) {

        return isBal(root);
        
    }

    public boolean isBal(TreeNode root){

        if(root == null) return true;

        boolean b = isBal(root.left);
        b = b && isBal(root.right);
        
        
        int l = isBalanced(root.left, 0);
        int r = isBalanced(root.right, 0);
        
        return b && (l == r+1 || l == r || l+1 == r);
    }
    
    public int isBalanced(TreeNode root, int i){
        if(root == null) return i;

        
        return Math.max( isBalanced(root.left, i+1),
        isBalanced(root.right, i+1) );
        
        
    }
}