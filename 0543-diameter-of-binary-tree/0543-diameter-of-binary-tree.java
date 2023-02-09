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
    public int diameterOfBinaryTree(TreeNode root) {
         
        return bTree(root, 0);
        
    }

    public int bTree(TreeNode root, int sum){
       if(root == null){
           return sum;
       }
            int l = diameterOfBinaryTree(root.left, 0);
            int r = diameterOfBinaryTree(root.right, 0);
            sum = Math.max(sum, (l+r) );
            

        return Math.max( bTree(root.left, sum), bTree(root.right, sum) );
    }

    public int diameterOfBinaryTree(TreeNode root, int i) {



        if(root == null ) return i;
      
        int l = diameterOfBinaryTree(root.left, i+1);
        int r = diameterOfBinaryTree(root.right, i+1);

    
        return Math.max(l, r);
    }
}