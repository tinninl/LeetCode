def threeSum(self, nums: List[int]) -> List[List[int]]:

    nums.sort()

    res = []
    miniRes = []

    l = 0
    r = len(nums) - 1

    for i, n in enumerate(nums):

        if (n > 0):
            continue

        if i > 0 and  n == nums[i - 1] :
            continue

        target = 0 - n
        l = i + 1
        r = len(nums) - 1

        while (l < r):

            sum = nums[l] + nums[r]

            if (sum > target):
                r -= 1

            elif (sum < target):
                l += 1

            else: 
                miniRes = [nums[i], nums[l], nums[r]]
                res.append(miniRes)

                while (l < r and nums[l] == nums[l + 1] and l < r):
                    l += 1

                while (l < r and nums[r] == nums[r - 1]):
                    r -= 1

                l += 1
                r -= 1

    return res




    
