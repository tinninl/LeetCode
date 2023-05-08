def trap(self, height: List[int]) -> int:

    if (len(height) == 0):
        return 0

    l = 0
    r = len(height) - 1

    maxLeft = 0
    maxRight = 0

    area, totalArea = 0, 0

    while (l <= r):

        if (maxLeft < maxRight):

            area = max(maxLeft - height[l], 0)

            totalArea += area

            maxLeft = max(height[l], maxLeft)

            l += 1

        else:

            area = max(maxRight - height[r], 0)

            totalArea += area

            maxRight = max(height[r], maxRight)

            r -= 1

    return totalArea



