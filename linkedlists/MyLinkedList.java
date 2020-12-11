
/*
707. Design Linked List
Medium

https://leetcode.com/problems/design-linked-list/

Runtime: 7 ms, faster than 95.23% of Java online submissions for Design Linked List.
Memory Usage: 39.9 MB, less than 27.08% of Java online submissions for Design Linked List.

Design your implementation of the linked list. You can choose to use a singly or doubly linked list.
A node in a singly linked list should have two attributes: val and next. val is the value of the current node, and next is a pointer/reference to the next node.
If you want to use the doubly linked list, you will need one more attribute prev to indicate the previous node in the linked list. Assume all nodes in the linked list are 0-indexed.

Implement the MyLinkedList class:

    MyLinkedList() Initializes the MyLinkedList object.
    int get(int index) Get the value of the indexth node in the linked list. If the index is invalid, return -1.
    void addAtHead(int val) Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list.
    void addAtTail(int val) Append a node of value val as the last element of the linked list.
    void addAtIndex(int index, int val) Add a node of value val before the indexth node in the linked list. If index equals the length of the linked list, the node will be appended to the end of the linked list. If index is greater than the length, the node will not be inserted.
    void deleteAtIndex(int index) Delete the indexth node in the linked list, if the index is valid.

 

Example 1:

Input
["MyLinkedList", "addAtHead", "addAtTail", "addAtIndex", "get", "deleteAtIndex", "get"]
[[], [1], [3], [1, 2], [1], [1], [1]]
Output
[null, null, null, null, 2, null, 3]

Explanation
MyLinkedList myLinkedList = new MyLinkedList();
myLinkedList.addAtHead(1);
myLinkedList.addAtTail(3);
myLinkedList.addAtIndex(1, 2);    // linked list becomes 1->2->3
myLinkedList.get(1);              // return 2
myLinkedList.deleteAtIndex(1);    // now the linked list is 1->3
myLinkedList.get(1);              // return 3

 

Constraints:

    0 <= index, val <= 1000
    Please do not use the built-in LinkedList library.
    At most 2000 calls will be made to get, addAtHead, addAtTail,  addAtIndex and deleteAtIndex.

Accepted
87,223
Submissions
343,086

*/
class MyLinkedList {
    
    class ListNode{
        int val;
        ListNode next;
        ListNode(int val, ListNode next){
            this.val = val;
            this.next = next;
        }
        
        ListNode(int val){
            this.val = val;
        }
    }
    ListNode head, tail;
    int size;
    /** Initialize your data structure here. */
    public MyLinkedList() {
        this.head = this.tail = null;   
        this.size = 0;
    }
    
    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        if(index >= this.size)
            return -1;
        if(index == 0)
            return this.head.val;
        else if(index == this.size - 1)
            return this.tail.val;
        else{
            int i = 0;
            ListNode prev = null;
            ListNode tmp = this.head;
            while(i < index){
                prev = tmp;
                tmp = tmp.next;
                i++;
            }
            return tmp.val;
        }
    }
    
    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        if(this.head == null)
            this.head = this.tail = new ListNode(val);
        else
            this.head = new ListNode(val, this.head);
        this.size++;
    }
    
    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        if(this.head == null)
            this.head = this.tail = new ListNode(val);
        else{
            this.tail.next = new ListNode(val);
            this.tail = this.tail.next;
        }
        this.size++;
    }
    
    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        if(index > this.size)
            return;
        if(index == this.size)
            this.addAtTail(val);
        else if(index == 0)
            this.addAtHead(val);
        else {
            int i = 0;
            ListNode prev = null;
            ListNode tmp = this.head;
            while(i < index){
                prev = tmp;
                tmp = tmp.next;
                i++;
            }
            prev.next = new ListNode(val, tmp);
            this.size++;
        }
    }
    
    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        if(index >= this.size)
            return;
        if(index == 0)
            this.deleteFromHead();
        else if(index == this.size - 1)
            this.deleteFromTail();
        else{
            int i = 0;
            ListNode prev = null;
            ListNode tmp = this.head;
            while(i < index){
                prev = tmp;
                tmp = tmp.next;
                i++;
            }
            prev.next = tmp.next;
            this.size--;
        }
    }
        
    private void deleteFromHead(){
        if(this.head == null)
            return;
        else {
            if(this.head == this.tail)
                this.head = this.tail = null;
            else
                this.head = this.head.next;
            this.size--;
        }
    }
    
    private void deleteFromTail(){
        if(this.head == null)
            return;
        else {
            if(this.head == this.tail)
                this.head = this.tail = null;
            else{
                ListNode tmp = this.head;
                for(tmp = this.head; tmp.next != this.tail; tmp = tmp.next);
                this.tail = tmp;
                this.tail.next = null;
            }
            this.size--;
        }
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */
