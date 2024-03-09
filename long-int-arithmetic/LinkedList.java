
public class LinkedList {

    static class Node {
        protected int data;
        protected Node next;
        public Node(int data) {
            this.data = data;
            this.next = null;
        }
        public void setNext(Node next) {
            this.next = next;
        }
        public Node getNext() {
            return next;
        }
        public int getData() {
            return data;
        }
        public String toString() {
            return "" + data;
        }
    }


        protected Node head;
        protected Node tail;

        public boolean isEmpty() {
            return head == null;
        }

        public Node getHead() {
            return head;
        }

    public void stringToIntList(String s) {
            for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int digit = Character.getNumericValue(c);
            Node n = new Node(digit);
            if (head == null) {
                head = n;
                tail = n;
            } else {
                tail.next = n;
                tail = n;
            }

        }
    }

    public void insertFirst(int num) {
            Node newNode = new Node(num);
            if (isEmpty()) {
                tail = newNode;
            }
            newNode.setNext(head);
            head = newNode;
        }
    public void insertLast(int num) {
            Node newNode = new Node(num);
        if (isEmpty()) {
            head = newNode;
        } else {
            tail.setNext(newNode);
        }
        tail = newNode;
    }

    public void deleteFirst () {
            head = head.getNext();
        if (isEmpty()) {
            tail = null;
          }
        }

    public int numberOfElements () {
        Node tmp = head;
        int count = 0;
        while (tmp != null) {
            count++;
            tmp = tmp.getNext();
        }
        return count;
    }

    public int getNodeIVal ( int i){
            Node tmp = head;
            int index = 0;
            while (tmp != null) {
                if (index == i) {
                    return tmp.data;
                }
                index++;
                tmp = tmp.getNext();
            }
            return 0;
        }

    public String toString () {
            StringBuilder result = new StringBuilder();
            Node tmp = head;
            while (tmp != null) {
                result.append(tmp);
                tmp = tmp.getNext();
                    }
            return " " + result;
                }
            }


