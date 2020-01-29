

def isPalindrome(string: str)->bool:
    if len(string) < 2:
        return True
    else:
        if string[0] != string[len(string) - 1]:
            return False
        else:
            return isPalindrome(string[1: len(string) - 1])


string1: str = "kayak"
string2: str = "aibohphobia"

print(isPalindrome(string1))
print(isPalindrome(string2))

# no slicing
def isPalindrome2(string: str, start: int, end: int)->bool:
    if start >= end:
        return True
    else:
        if string[start] != string[end]:
            return False
        else:
            return isPalindrome2(string, start + 1, end - 1)


print(isPalindrome2(string1, 0, len(string1) - 1))
print(isPalindrome2(string2, 0, len(string2) - 1))


