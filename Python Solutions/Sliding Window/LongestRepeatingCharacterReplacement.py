def characterReplacement(self, s: str, k : int) -> int:
    
    l = 0
    
    maxf = 0
    
    count = {}
    
    for r in range(len(s)):
        count[s[r]] = 1 + count.get(s[r], 0)
        maxf = max(maxf, count[s[r]])
        
        # Our window can have only k + 1 distinct elements
        # length = r - 1 + 1
        if (r - l + 1 > max + k):
            count[s[l]] -= 1
            l+= 1
            
    return r + l - 1