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
    public int goodNodes(TreeNode root) {
        
        Queue<TreeNode> q = new LinkedList();
        Queue<Integer> q1 = new LinkedList();
        
        q.add(root);
        q1.add(root.val);
        int sum = 1;

        while( !q.isEmpty()){
            TreeNode n = q.poll();
            int n1 = q1.poll();
            // System.out.println(n.val +", "+ n1);

            if( n.left != null){
                 q.add(n.left);
                 if( n1 > n.left.val ){
                     q1.add(n1);
                 }else{
                     q1.add(n.left.val);
                     sum++;
                 }
            }
            if( n.right != null){
                q.add(n.right);
                if( n1 > n.right.val ){
                     q1.add(n1);
                 }else{
                     q1.add(n.right.val);
                     sum++;
                 }
            }

        }

        return sum;


    }
}