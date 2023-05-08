def longestConsecutive(self, nums: list[int]) -> int:
    
    numSet = set(nums)
    
    longest = 0
    
    for n in numSet:
        
        # Check if its the start of a new sequence
        if (n - 1) not in numSet:
            length = 1
            
            while (n + 1) in numSet:
                n += 1
                length += 1
                
            longest = max(longest, length)
            
        if longest > (len(nums) / 2):
            break
        
    return longest