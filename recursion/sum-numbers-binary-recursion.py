
def sum(arr: list, start: int, end: int)->int:
    if start > end:
        return 0
    elif start == end:
        return arr[start]
    else:
        midpoint: int = int(start + (end - start) / 2)
        return sum(arr, start, midpoint) + sum(arr, midpoint + 1, end)


numbers1: list = []
numbers2: list = [1]
numbers3: list = [1, 2, 3]

print(sum(numbers1, 0, len(numbers1) - 1))
print(sum(numbers2, 0, len(numbers2) - 1))
print(sum(numbers3, 0, len(numbers3) - 1))