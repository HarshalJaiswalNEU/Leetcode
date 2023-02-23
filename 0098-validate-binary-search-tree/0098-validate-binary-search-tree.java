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
    public boolean isValidBST(TreeNode root) {

        List<Integer> al = new LinkedList();
        dfs( root, al);
        // System.out.println(al);
        int j = al.get(0);
        for( int i =1; i< al.size(); i++){
            if( j >= al.get(i)){
                // System.out.println(j +", "+al.get(i) );
                return false;
            }
            j = al.get(i);
        }

        return true;
        
        // Queue<TreeNode> q = new LinkedList();
        // q.add(root);
        // List<Integer> al = new LinkedList();
        // while( !q.isEmpty()){
            
        //     TreeNode n = q.peek();
           
            
        //     if( n.left != null){
        //         if( n.val <= n.left.val){
        //             // System.out.println(n.val+", " +n.left.val);
        //             return false;
        //         }
        //         q.add(n.left);
        //         // n = n.left;
        //     }
        //      System.out.println(q.peek().val+", ");
        //     //  System.out.println(n.val+", r");
        //      n = q.poll();

        //     if( n.right != null){
        //         if( n.val >= n.right.val){
        //             // System.out.println(n.val+", " +n.right.val);
        //             return false;
        //         }
        //         q.add(n.right);
        //         // n = n.right;
        //     }
            
            
        // }
        
        // return true;
    }

    public void dfs(TreeNode root,List<Integer> al){
        if( root == null){
            return ;
        }

          dfs( root.left, al);
          al.add(root.val);
          dfs( root.right, al);
        
    }
}