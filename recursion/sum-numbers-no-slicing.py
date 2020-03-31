
def sum(arr: list, index: int)->int:
    if len(arr) == 0:
        return 0
    elif index == 0:
        return arr[index]
    else:
        return arr[index] + sum(arr, index - 1)


numbers1: list = []
numbers2: list = [1]
numbers3: list = [1, 2, 3]

print(sum(numbers1, len(numbers1) - 1))
print(sum(numbers2, len(numbers2) - 1))
print(sum(numbers3, len(numbers3) - 1))