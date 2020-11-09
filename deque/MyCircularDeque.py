'''

Runtime: 64 ms, faster than 94.68% of Python3 online submissions for Design Circular Deque.
Memory Usage: 14.5 MB, less than 63.03% of Python3 online submissions for Design Circular Deque.

'''
class MyCircularDeque:

    def __init__(self, k: int):
        """
        Initialize your data structure here. Set the size of the deque to be k.
        """
        self.length: int = k
        self.left = self.right = -1
        self.deque = [None] * self.length
        

    def insertFront(self, value: int) -> bool:
        """
        Adds an item at the front of Deque. Return True if the operation is successful.
        """
        if self.isFull():
            return False
        if self.left == -1:
            self.left = self.right = 0
            self.deque[self.left] = value
            return True
        elif self.left == 0:
            self.left = len(self.deque) - 1
            self.deque[self.left] = value
            return True
        else:
            self.left = self.left - 1
            self.deque[self.left] = value
            return True
        

    def insertLast(self, value: int) -> bool:
        """
        Adds an item at the rear of Deque. Return True if the operation is successful.
        """
        if self.isFull():
            return False
        if self.left == -1: 
            self.left = self.right = 0
            self.deque[self.left] = value
            return True
        elif self.right == self.length - 1:
            self.right = (self.right + 1) % self.length
            self.deque[self.right] = value
            return True
        else:
            self.right += 1
            self.deque[self.right] = value
            return True
        

    def deleteFront(self) -> bool:
        """
        Deletes an item from the front of Deque. Return True if the operation is successful.
        """
        if self.isEmpty():
            return False
        if self.left == self.right:
            self.left = self.right = -1
            return True
        
        else:
            if self.left == self.length - 1:
                self.left = 0
            else:
                self.left += 1
            return True
        
        

    def deleteLast(self) -> bool:
        """
        Deletes an item from the rear of Deque. Return True if the operation is successful.
        """
        if self.isEmpty():
            return False
        if self.left == self.right:
            self.left = self.right = -1
            return True
        
        else:
            if self.right == 0:
                self.right = self.length - 1
            else:
                self.right -= 1
            return True
        
        

    def getFront(self) -> int:
        """
        Get the front item from the deque.
        """
        if self.isEmpty():
            return -1
        return self.deque[self.left]
            

    def getRear(self) -> int:
        """
        Get the last item from the deque.
        """
        if self.isEmpty():
            return -1
        return self.deque[self.right]
        

    def isEmpty(self) -> bool:
        """
        Checks whether the circular deque is empty or not.
        """
        return self.left == -1
        

    def isFull(self) -> bool:
        """
        Checks whether the circular deque is full or not.
        """
        return (self.right + 1) % self.length == self.left


# Your MyCircularDeque object will be instantiated and called as such:
# obj = MyCircularDeque(k)
# param_1 = obj.insertFront(value)
# param_2 = obj.insertLast(value)
# param_3 = obj.deleteFront()
# param_4 = obj.deleteLast()
# param_5 = obj.getFront()
# param_6 = obj.getRear()
# param_7 = obj.isEmpty()
# param_8 = obj.isFull()