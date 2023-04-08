class Solution:
    def firstUniqChar(self, s: str) -> int:
        res = {}
        
        for ch in s:
            if ch not in res:
                res[ch] = 0
            res[ch] += 1
            
        i = 0
        for ch in s:
            if res[ch] < 2:
                return i
            
            i += 1
            
        return -1
        