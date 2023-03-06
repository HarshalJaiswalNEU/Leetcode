class Solution {
    public int rob(int[] nums) {
        if( nums.length <= 3){
            int mx = 0;
            for( int i:nums){
                mx = Math.max(i, mx);
            }
            return mx;
        }
        


        int[] dp = new int[nums.length];
        int[] vis = new int[nums.length];


    // nums = [ 10, 3, 14,20, 10]
        Arrays.fill( dp, 0);
        Arrays.fill( vis, 0);
        vis[0] = nums[0];
        vis[1] = (nums[1]);
        vis[2] = nums[2];
    //vis = [max(10,3), max(10,3), 14, 0, 0 ]
        dp[0] = nums[0];
        dp[1] = nums[1];
        dp[2] = dp[0] + nums[2];
        // dp = [10, 3, (10+14), 0, 0]


    // i= 3-> n
        for( int i = 3; i < nums.length-1; i++){
            dp[i] = nums[i] + Math.max( dp[i-2], dp[i-3]);        
        }


        for( int i = 3; i < nums.length; i++){
            if( i -3 != 0){
                vis[i] = nums[i] + Math.max( vis[i-2], vis[i-3]);        
            }else{
                vis[i] = nums[i] +( vis[i-2]);
            }
            
        }

        // System.out.println( Arrays.toString(dp));
        // System.out.println( Arrays.toString(vis));
        
        int mx =-1;
        for( int i = 0; i< nums.length; i++){
            mx = Math.max(mx , vis[i] );
            mx = Math.max(mx , dp[i] );
            System.out.println( mx);
        }

        return mx;

    }
}