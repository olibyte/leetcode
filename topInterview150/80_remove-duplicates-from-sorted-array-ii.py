class Solution:
    def removeDuplicates(self, nums: List[int]) -> int:
        if not nums:
            return 0
        left = 0
        count = 1  # Initialize count for the first occurrence
        for right in range(1, len(nums)):
            if nums[right] == nums[left]:
                count += 1
            else:
                count = 1  # Reset count for a new element
            if count <= 2:
                left += 1
                nums[left] = nums[right]
        
        return left + 1
    
'''
Two pointers, left and right, both pointing to the start of the array.
Variable count tracks of #no of occurrences of the current element.
Iterate:
1.If right element equals left element, increment count.
2.If right element is different from left element, reset count to 1.
3.If count is less than or equal to 2, move left pointer forward, copy right element to the position pointed by left. Loop will move right pointer forward
4. Repeat step 3 until the right pointer reaches the end of the array.
Return the position of the left pointer, which represents the number of unique elements in the modified array.
'''