class Solution:
    def removeDuplicates(self, nums: List[int]) -> int:
        set_n = {}
        for i in nums:
            # if i in set_n:
            #     return i
            set_n[i]= 1;
        j = 0
        for i in set_n.keys():
            nums[j] = i
            j += 1
        # print( set_n)
        return len(set_n)