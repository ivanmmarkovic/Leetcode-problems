
public class InsertIntoSortedCircularLinkedList {
	public class ListNode {
		int val;
		ListNode next;

		ListNode() {
		}

		ListNode(int val) {
			this.val = val;
		}

		ListNode(int val, ListNode next) {
			this.val = val;
			this.next = next;
		}
	}

	public ListNode insertNode(ListNode head, int val) {
		if (head == null)
			return null;

		boolean inserted = false;
		ListNode tmp = head;
		ListNode prev = null;
		do {
			if (tmp.val > val || tmp.val == val) {
				if (tmp == head)
					head = new ListNode(val, tmp);
				else
					prev.next = new ListNode(val, tmp);
				inserted = true;
				break;
			}
			prev = tmp;
			tmp = tmp.next;
		} while (tmp != head);
		if (!inserted) {
			prev.next = new ListNode(val, tmp);
		}
		return head;
	}
}
