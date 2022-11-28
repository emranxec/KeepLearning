package dataStructure;

public class SimpleLinkedList {


        // create an object of Node class
        // represent the head of the linked list
        Node head;

        // static inner class
        static class Node {
            int value;

            // connect each node to next node
            Node next;

            Node(int d) {
                value = d;
                next = null;
            }
        }

        public static void main(String[] args) {

            // create an object of simpleLinkedList
            SimpleLinkedList simpleLinkedList = new SimpleLinkedList();

            // assign values to each linked list node
            simpleLinkedList.head = new Node(1);
            Node second = new Node(2);
            Node third = new Node(3);

            // connect each node of linked list to next node
            simpleLinkedList.head.next = second;
            second.next = third;

            // printing node-value
            System.out.print("simpleLinkedList: ");
            while (simpleLinkedList.head != null) {
                System.out.print(simpleLinkedList.head.value + " ");
                simpleLinkedList.head = simpleLinkedList.head.next;
            }
        }
    }
