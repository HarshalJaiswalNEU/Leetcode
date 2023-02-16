class Solution {
    public int missingNumber(int[] nums) {
        
        int l = nums.length;
        Set<Integer> set = new HashSet();
        
        for(int n: nums){
            
            set.add(n);
        }
        for(int i=0; i< l; i++){
            if( set.add(i)){
                return i;
            }
        }
        return l;

    }
}