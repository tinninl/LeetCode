def carfleets(target: int, position: list[int], speed: list[int]) -> int:

    fleets = 0

    pairs = []

    for p, s in zip(position, speed):

        arrTime = (target - p) / s
        pairs.append([p, arrTime])

    # print(pairs)

    prev = 0

    for p, arrTime in pairs[::-1]:

        if arrTime > prev:
            prev = arrTime
            fleets += 1

    # print ("fleets =", fleets)

    return fleets

position = [10, 8, 0, 5, 3]
speed = [2, 4, 1, 1, 3]
target = 12

print(carfleets(target, position, speed))








