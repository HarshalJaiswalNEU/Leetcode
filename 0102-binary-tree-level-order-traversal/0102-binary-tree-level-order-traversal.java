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

    public List<List<Integer>> levelOrder(TreeNode root) {
        Map<Integer, List<Integer>> map = new HashMap();
        dfs( root, map, 0);

        List<List<Integer>> res = new ArrayList<List<Integer>>();
        // System.out.println(map);
        map.forEach( (k,v)->{
            res.add(v);
        });
        return res;


    }

    public void dfs(TreeNode root, Map<Integer, List<Integer>> map, int i){

        if( root == null) return;

        List<Integer> al = map.getOrDefault( i, new LinkedList<Integer>() );

        al.add(root.val);
        map.put( i, al);
        dfs( root.left, map, i+1);
        dfs( root.right, map, i+1);

    }


}