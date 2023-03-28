


class Solution:
    
    def commond(self, d1 , d2) -> List[int]:
        res = []
        for i in d1.keys():
            if i in d2:
                if d1[i] < d2[i]:
                    for l in range(0, d1[i]):
                        res.append(i)
                else :
                    for l in range(0, d2[i]):
                        res.append(i)

        return res
                        
        
    def intersect(self, nums1: List[int], nums2: List[int]) -> List[int]:
        
        
        d1 = {}
        d2 = {}
        
        for i in nums1:
            if i in d1:
                d1[i] += 1
            else :
                d1[i] = 1
        
        for i in nums2:
            if i in d2:
                d2[i] += 1
            else :
                d2[i] = 1
                
        # sayHello()
                
        # print( commond( d1, d2))
        
        if len(d1) > len(d2):
            return self.commond( d1, d2)
        
        return self.commond(d2, d1)
                