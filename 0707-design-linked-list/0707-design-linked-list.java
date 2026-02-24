class MyLinkedList {

    // Node definition
    class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }

    private ListNode head;
    private int size;

    public MyLinkedList() {
        head = null;
        size = 0;
    }

    // Get value at index
    public int get(int index) {
        if (index < 0 || index >= size) return -1;

        ListNode curr = head;
        for (int i = 0; i < index; i++) {
            curr = curr.next;
        }
        return curr.val;
    }

    // Add node at head
    public void addAtHead(int val) {
        ListNode node = new ListNode(val);
        node.next = head;
        head = node;
        size++;
    }

    // Add node at tail
    public void addAtTail(int val) {
        ListNode node = new ListNode(val);

        if (head == null) {
            head = node;
        } else {
            ListNode curr = head;
            while (curr.next != null) {
                curr = curr.next;
            }
            curr.next = node;
        }
        size++;
    }

    // Add node at specific index
    public void addAtIndex(int index, int val) {

        if (index < 0 || index > size) return;

        if (index == 0) {
            addAtHead(val);
            return;
        }

        if (index == size) {
            addAtTail(val);
            return;
        }

        ListNode node = new ListNode(val);
        ListNode curr = head;

        for (int i = 0; i < index - 1; i++) {
            curr = curr.next;
        }

        node.next = curr.next;
        curr.next = node;
        size++;
    }

    // Delete node at index
    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) return;

        if (index == 0) {
            head = head.next;
        } else {
            ListNode curr = head;
            for (int i = 0; i < index - 1; i++) {
                curr = curr.next;
            }
            curr.next = curr.next.next;
        }
        size--;
    }
}
