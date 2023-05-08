import collections

def minWindow(self, nums: list[int], k: int) -> list[int]:
    
    res = []
    
    index = 0
    
    q = collections.deque()
    
    for i in range(len(nums)):
        
        if q and nums[q[-1]] < nums[i]:
            q.popleft
            
        while q and (q[0] < i + k - 1):
            q.pop
            
        if i >= k - 1:
            res.append(q[0])
            
    return res
    