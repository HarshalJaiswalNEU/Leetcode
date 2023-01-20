class Solution {
    public boolean canJump(int[] nums) {
        
        int j = 0;
        
        if(nums.length == 1)
            return true;
        for(int i =0; i<= nums.length-2 ;i++){
           
            j = Math.max(nums[i], j);
            
            if(j == 0  )
                return false;
            j--;
        }
            
        return true;
    }
}