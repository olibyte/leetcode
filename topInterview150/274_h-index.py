class Solution:
    def hIndex(self, citations: List[int]) -> int:
        n = len(citations)
        h_index = 0
        citations.sort() #sort ascending, O(nlogn) time
        for i in range(n):
            h_index = max(h_index, min(n-i,citations[i]))
        return h_index #no extra memory, just 2 variables. O(1) space.