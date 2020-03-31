
def fibonacci_sum(n: int)->int:
    def fibonacci_sum_helper(n: int, acc: int, prev: int, curr: int)->int:
        if n == 1:
            return acc
        elif n == 2:
            return acc + curr
        else:
            return fibonacci_sum_helper(n - 1, acc + curr, curr, prev + curr)

    return fibonacci_sum_helper(n, 0, 0, 1)


print(fibonacci_sum(1))
print(fibonacci_sum(2))
print(fibonacci_sum(3))
print(fibonacci_sum(4))
print(fibonacci_sum(5))
