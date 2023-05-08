def maxArea(self, height: List[int]) -> int:

    l = 0
    r = len(height) - 1

    maxArea = 0;

    while l < r:

        w = r - l
        h = min(height[l], height[r])
        area = w * h

        maxArea = max(area, maxArea)

        if (height[l] < height[r]):
            l += 1

        else:
            r -= 1

    return maxArea


