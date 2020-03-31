def fibonacci_sum(n: int, acc: int, prev: int, curr: int):
    if n == 1:
        return acc
    elif n == 2:
        return acc + curr
    else:
        return fibonacci_sum(n - 1, acc + curr, curr, prev + curr)


print(fibonacci_sum(1, 0, 0, 1))
print(fibonacci_sum(2, 0, 0, 1))
print(fibonacci_sum(3, 0, 0, 1))
print(fibonacci_sum(4, 0, 0, 1))
print(fibonacci_sum(5, 0, 0, 1))
