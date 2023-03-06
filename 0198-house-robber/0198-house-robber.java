class Solution {
    public int rob(int[] nums) {
        
        if( nums.length <= 2){
            if( nums.length == 1){
                return nums[0];
            }
            return Math.max(nums[0], nums[1]);
        }
        

        int[] dp = new int[nums.length];
        Arrays.fill( dp, 0);
        dp[nums.length-1] = nums[nums.length-1];
        dp[nums.length-2] = nums[nums.length-2];
        dp[nums.length-3] = nums[nums.length-3] + dp[nums.length-1];

        for( int i = nums.length-4; i >=0 ; i--){

            dp[i] = nums[i]+Math.max(dp[ i+2], dp[i+3]);
        }

        // System.out.println( Arrays.toString(dp) );
        return dp[0]>dp[1] ? dp[0] : dp[1];

    }
}