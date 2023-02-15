class Solution {
    List<List<Integer>> res = new ArrayList<List<Integer>>();
    public List<List<Integer>> subsets(int[] nums) {
        for(int i =0; i <= nums.length; i++ ){
            dfs(i, nums, new ArrayList(), 0);
        }

        return res;
        
    }

    public void dfs(int j, int[] nums, List<Integer> al, int k){
        if( al.size() == j ){
            res.add(new ArrayList(al) );
            return;
        }

        for(int i = k; i< nums.length; i++){
            al.add(nums[i]);
            dfs(j, nums, al, i+1);
            al.remove(al.size()-1);
        }
    }
}