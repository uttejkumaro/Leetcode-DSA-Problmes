class Solution:
    def findFinalValue(self, nums: List[int], original: int) -> int:
        # s=set(nums)
        # num=original
        # while num in s:
        #     num=num<<1
        # return num
        num=original
        while num in nums:
            num=num<<1
        return num
        