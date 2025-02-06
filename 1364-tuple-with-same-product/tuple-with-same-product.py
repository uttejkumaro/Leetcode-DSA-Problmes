class Solution(object):
    def tupleSameProduct(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        mp=Counter()
        l=len(nums)
        res=0
        for i in range(l-1):
            for j in range(i+1,l):
                prd=nums[i]*nums[j]
                res+=mp[prd]*8
                mp[prd]+=1
        return res

        