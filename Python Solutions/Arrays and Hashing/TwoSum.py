# nums is an array, target is an integer
def twoSum(self, nums: List[int], target: int) -> List[int]:

    result = []

    hashmap = {}

    for i in range(len(nums)):

        diff = target - nums[i]

        if diff in hashmap



