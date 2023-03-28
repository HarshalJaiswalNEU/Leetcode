class Solution:
    def plusOne(self, digits: List[int]) -> List[int]:
        res = []
        c = 1
        sum = 0
        
        for i in range( len(digits)-1, -1, -1 ):
            sum = c + digits[i] 
            
            if sum > 9:
                res.insert(0, int(sum % 10))
                c = sum / 10 
            else :
                res.insert(0, int(sum))
                c = 0
        if c > 0:
            res.insert(0, int(c))
          
            
        return res