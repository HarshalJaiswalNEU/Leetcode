class Solution {
    
    Set<List<Integer>> res = new HashSet<List<Integer>>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        dfs(nums, 0, new ArrayList());
        List<List<Integer>> ress = new ArrayList<List<Integer>>();
        res.forEach((v)->{
            ress.add(new ArrayList(v));
        });
        return ress;
    }

    public void dfs(int[] nums , int st, List<Integer> al){

        res.add(new ArrayList( al ));

        for( int i= st; i< nums.length; i++){
            al.add(nums[i]);
            dfs(nums, i+1, al);
            al.remove(al.size()-1);
        }


    }
}