
def listSum(alist: list)->int:
    if len(alist) == 0:
        return 0
    if len(alist) == 1:
        return alist[0]
    else:
        return alist[0] + listSum(alist[1:])



print(listSum([]))
print(listSum([1, 2, 3]))