class Solution(object):
    def longestMonotonicSubarray(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        inc,de,maxc=1,1,1
        for  i in range(len(nums)-1):
            if(nums[i]<nums[i+1]):
                inc+=1
                de=1
            elif(nums[i]>nums[i+1]):
                de+=1
                inc=1
            else:
                inc,de=1,1
            maxc=max(maxc,max(inc,de))
        return maxc
        
    
        