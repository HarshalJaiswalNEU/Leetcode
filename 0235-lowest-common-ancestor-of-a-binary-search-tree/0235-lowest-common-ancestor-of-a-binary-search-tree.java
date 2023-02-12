/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {

    List<TreeNode> al = new ArrayList();
    boolean pn = false;
    boolean qn = false;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        

        if( p.val > root.val && q.val > root.val){
            return lowestCommonAncestor(root.right, p, q);
        }else if(p.val< root.val && q.val < root.val){
            return lowestCommonAncestor(root.left, p, q);
        }
        else{
            return root;
        }
     
      
        
    }

    public void lca(TreeNode root, TreeNode p, TreeNode q){

        if( pn && qn) return ;

        if(root == null ) return ;


        
        System.out.println(root.val);
        
        if((root == p && !pn) || (root.left != null && ( root.left == p || root.left == q ) )){
            al.add(root);
            pn  = true;
        }
        
        if((root == q && !qn) || (root.right != null && ( root.right == p || root.right == q))){
            al.add(root);
            qn = true;
        }

        lca( root.left, p ,q);
        lca( root.right, p ,q);

    }


}