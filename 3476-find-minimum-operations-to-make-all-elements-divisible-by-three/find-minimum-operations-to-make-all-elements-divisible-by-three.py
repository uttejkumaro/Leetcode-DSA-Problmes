class Solution:
    def minimumOperations(self, nums: List[int]) -> int:
        ops=0
        for i in nums:
            ops+=min(i%3,3-i%3)
        return ops