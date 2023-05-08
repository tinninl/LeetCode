"""
bucket sort:
1,1,1,2,2, 100

count = [1:3 2:2 100:1]
count is a hashmap: key = number, value = frequency
freq = [ 100 2 1 0 0 0 ]
freq is a 2d array: index = number
"""


def topKFrequent(self, nums: List[int], k: int) -> List[int]:
    

    res = []
    count = {}
    freq =[[] for i in range(len(nums) + 1)]

    for n in nums:
        count[n] = 1 + count.get(n, 0)

    for n, c in count.items():
        freq[c].append(n)

    for i in range(len(freq) - 1, 0, -1):
        
        for n in freq[i]:
            res.append(n)
            if len(res) == k:
                break
            
    return res
