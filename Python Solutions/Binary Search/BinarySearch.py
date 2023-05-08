def search(self, nums: list[int], target: int) -> int:
    
    l = 0
    r = len(nums) - 1
    
    while l <= r:
        
        # Integer division uses two slashes and rounds down
        mid = (l + r) // 2
        
        if (nums[mid] < target):
            l = mid + 1
            
        elif (nums[mid] > target):
            r = mid - 1
            
        else: 
            return mid
        
    return -1
        
    
    