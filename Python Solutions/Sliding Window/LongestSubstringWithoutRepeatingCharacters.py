def lengthOfLongestSubstring(self, s: str) -> int:
    
    maxLength = 0
    
    left = 0
    
    charSet = set()
    
    for right in range(len(s)):
        
        while s[right] in charSet:
            charSet.remove(s[left])
            left += 1
            
        charSet.add(s[right])
        
        length = right - left + 1
        maxLength = max(maxLength, length)
        
    return maxLength
    