class Solution(object):
    def maxDifference(self, s):
        """
        :type s: str
        :rtype: int
        """
        map=Counter(s);
        min_even=float('inf')
        max_odd=float('-inf')
        for i in map.values():
            if(i%2==0):
                min_even=min(min_even,i)
            else:
                max_odd=max(max_odd,i)
        return max_odd-min_even