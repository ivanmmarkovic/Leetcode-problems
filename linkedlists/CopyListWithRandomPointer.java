
/*

138. Copy List with Random Pointer
Medium

https://leetcode.com/problems/copy-list-with-random-pointer/

Runtime: 0 ms, faster than 100.00% of Java online submissions for Copy List with Random Pointer.

A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.

Return a deep copy of the list.

The Linked List is represented in the input/output as a list of n nodes. Each node is represented as a pair of [val, random_index] where:

    val: an integer representing Node.val
    random_index: the index of the node (range from 0 to n-1) where random pointer points to, or null if it does not point to any node.

 

Example 1:

Input: head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
Output: [[7,null],[13,0],[11,4],[10,2],[1,0]]

Example 2:

Input: head = [[1,1],[2,1]]
Output: [[1,1],[2,1]]

Example 3:

Input: head = [[3,null],[3,0],[3,null]]
Output: [[3,null],[3,0],[3,null]]

Example 4:

Input: head = []
Output: []
Explanation: Given linked list is empty (null pointer), so return null.

 

Constraints:

    -10000 <= Node.val <= 10000
    Node.random is null or pointing to a node in the linked list.
    Number of Nodes will not exceed 1000.

Accepted
356,069
Submissions
1,079,558

*/
class CopyListWithRandomPointer {
    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
    public Node copyRandomList(Node head) {
        if(head == null)
            return null;
        
        Node originHead = head;
        Node tmp;
        while(originHead != null){
            tmp = new Node(originHead.val);
            tmp.next = originHead.next;
            originHead.next = tmp;
            originHead = originHead.next.next;
        }
        originHead = head;
        while(originHead != null){
            if(originHead.random == null)
                originHead.next.random = null;
            else 
                originHead.next.random = originHead.random.next;
            originHead = originHead.next.next;
        }
        
        Node result = new Node(0);
        tmp = result;
        while(head != null){
            tmp.next = head.next;
            head.next = head.next.next;
            head = head.next;
            tmp = tmp.next;
        }
        return result.next;
    }
}