def checkInclusion(self, s1: str, s2: str) -> bool:
    n = len(s1)
    m = len(s2)
    
    if n > m:
        return False
    
    store1 = [0] * 26
    store2 = [0] * 26
    
    for char in s1:
        store1[ord(char) - ord('a')] += 1
        
    for i in range(m):
        
        store2[ord(s2[i]) - ord('a')] += 1
        
        if i >= n:
            store2[ord(s2[i - n]) - ord('a')] -= 1
            
        if store1 == store2:
            return True
        
    return False
        
        