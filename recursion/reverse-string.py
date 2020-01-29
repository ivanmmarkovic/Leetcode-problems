
def reverser(string: str)->str:
    if len(string) == 0:
        return ""
    if len(string) == 1:
        return string[0]
    else:
        return reverser(string[1:]) + string[0]

string1: str = ""
string2: str = "this string will be reversed ..."

print(reverser(string1))
print(reverser(string2))

# no slicing
def reverser2(string: str, pointer: int)->str:
    if pointer < 0:
        return ""
    if pointer == 0:
        return string[pointer]
    else:
        return string[pointer] + reverser2(string, pointer - 1)


print(reverser2(string1, len(string1) - 1))
print(reverser2(string2, len(string2) - 1))

def reverser3(string: str)->str:
    if len(string) == 0:
        return ""
    if len(string) == 1:
        return string[0]
    else:
        return string[len(string) - 1] + reverser3(string[0: len(string) - 1])

print(reverser3(string1))
print(reverser3(string2))