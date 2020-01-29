from stack import Stack

def converter(num, base):
    digits = "0123456789ABCDEF"
    stack = Stack()
    while num > 0:
        stack.push(digits[num % base])
        num = num // base
    
    result: str = ""
    while not stack.isEmpty():
        result += stack.pop()

    return result


print(converter(1453,16)) # 5AD