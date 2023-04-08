class Solution:
    def reverse(self, x: int) -> int:
        res = 0
        f = 1
        if x < 0:
            f = -1
            x = x*-1;
      
        while x != 0:
          
            res = res*10 +  int(x%10)
            x = int(x/10)
            if res >= (2**31) or res < -(2**31):
                return 0
           
            print( res, x )
            
            
        return f*res
        