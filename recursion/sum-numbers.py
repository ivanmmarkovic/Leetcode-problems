
def sum(arr: list)->int:
    if len(arr) == 0:
        return 0
    elif len(arr) == 1:
        return arr[0]
    else:
        return arr[0] + sum(arr[1:])


numbers1: list = []
numbers2: list = [1]
numbers3: list = [1, 2, 3]

print(sum(numbers1))
print(sum(numbers2))
print(sum(numbers3))