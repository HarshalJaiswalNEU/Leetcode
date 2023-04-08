class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        
        m1 = {}
        m2 = {}
        
        for ch in s:
            if ch not in m1:
                m1[ch] = 0
                
            m1[ch] += 1
            
        for ch in t:
            if ch not in m2:
                m2[ch] = 0
                
            m2[ch] += 1
            
        return m1 == m2