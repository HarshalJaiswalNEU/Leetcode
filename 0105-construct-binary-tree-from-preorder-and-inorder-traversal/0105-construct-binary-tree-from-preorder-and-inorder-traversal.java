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
     int i=0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        
        Map<Integer, Integer> map = new HashMap();

        for(int i =0; i< inorder.length ; i++){
            map.put(inorder[i], i);
        }

        return dfs(preorder, 0, inorder.length-1, map);
        
    }

    public TreeNode dfs(int[] preorder, int l, int r, Map<Integer, Integer> map){

        if( l > r){
            return null ;
        }
        
        int m = map.get(preorder[i]);
        TreeNode root = new TreeNode(preorder[i]);
        i++;

        root.left = dfs( preorder,l ,m -1 , map);
        root.right = dfs(preorder, m +1, r, map);
     

        return root;
    }

     
}