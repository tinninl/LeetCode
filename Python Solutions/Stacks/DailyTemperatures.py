def dailyTemperatures(self, temps: list[int]) -> list[int]:

    res = [0] * len(temps)
    stack = []

    for day in range(len(temps)):

        while (stack and (temps[day] > temps[stack[-1]])):

            prevDay = stack.pop()
            res[prevDay] = day - prevDay

        stack.append(day)

    return res

