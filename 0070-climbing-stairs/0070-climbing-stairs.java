class Solution {
    public int climbStairs(int n) {
        
        int a = 1, b = 1, sum = 0;
        
        if( n <=3){
            return n;
        }
        
        for( int i = 1; i< n ;i++){
            sum = a+b;
            b = a;
            a = sum;
        }
        
        return sum;
        
    }
}