def sum(numbers: list)->int:
    if len(numbers) == 0:
        return 0
    elif len(numbers) == 1:
        return numbers[0]
    else:
        return numbers[0] + sum(numbers[1:])

numbers1: list = []
numbers2: list = [1]
numbers3: list = [1, 2, 3]

print(sum(numbers1))
print(sum(numbers2))
print(sum(numbers3))


def sum2(numbers: list, end: int)->int:
    if len(numbers) == 0:
        return 0
    elif end == 0:
        return numbers[end]
    else:
        return numbers[end] + sum2(numbers, end - 1)


print(sum2(numbers1, len(numbers1) - 1))
print(sum2(numbers2, len(numbers2) - 1))
print(sum2(numbers3, len(numbers3) - 1))