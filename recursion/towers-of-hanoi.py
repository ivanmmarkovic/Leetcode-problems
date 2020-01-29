
def printMove(start: str, end: str):
    print("Move from", start, "to", end)

def towers(num: int, start: str, spare: str, end: str):
    if num == 1:
        printMove(start, end)
    else:
        towers(num - 1, start, end, spare)
        towers(1, start, spare, end)
        towers(num - 1, spare, start, end)


towers(3, "start", "spare", "end")