
1. mark starting position with 1

2. check possible moves - left, right, up, down

3. if there is a possible move, mark in matrix with 1 and push coordinates in stack

4. if there are no possible moves, pop coordinates from stack

5. check for possible moves again from coordinates from stack - stack.peek() 

6. until path is found or stack is empty
