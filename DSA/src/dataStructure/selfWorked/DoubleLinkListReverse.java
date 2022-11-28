package dataStructure.selfWorked;

class node {
    Object value;
    node nextnode;
    node previousnode;
}

class LinkedList{
    node node;
    int current=0;

    LinkedList() {
        node = new node();
        node.nextnode = null;
        node.previousnode =null;
    }

    void add(Object value) {
        if (node.value == null) {
            node.value=value;
            node newnode =new node();
            newnode.previousnode = node;
            node.nextnode = newnode;
        } else {
            addChild(value, node.nextnode);
        }

    }

    private void addChild(Object value, node childnode) {
        if (childnode.value == null) {
            childnode.value=value;
            node newnode =new node();
            newnode.previousnode = childnode;
            childnode.nextnode = newnode;
        } else {
            addChild(value, childnode.nextnode);
        }
    }

    void remove(Object value) {
        if(value!=null){
            if(node.value!=null && node.value==value){
                node = node.nextnode;
            }else{
                removeChild(value, node.nextnode);
            }
        }

    }
    void removefrom(int index) {
        if(index==0){
            node = node.nextnode;
        }else{
            current++;
            removeChildFrom(index, node.nextnode);
        }
        current=0;
    }

    private void removeChildFrom(int value, node childnode) {
        if(current==value){
            childnode.previousnode.nextnode = childnode.nextnode;
        }else{
            if(childnode.nextnode ==null) return;
            current++;
            removeChild(value, childnode.nextnode);
        }
    }

    private void removeChild(Object value, node childnode) {
        if(childnode.value!=null && childnode.value==value){
            childnode.previousnode.nextnode = childnode.nextnode;
        }else{
            if(childnode.nextnode ==null) return;
            removeChild(value, childnode.nextnode);
        }
    }

    void printAll(boolean printReverse) {
        node printnode = node;
        if(!printReverse) {
            while (printnode.value != null) {
                System.out.println(printnode.value);
                if (printnode.nextnode != null) {
                    printnode = printnode.nextnode;
                } else {
                    break;
                }
            }
        }else{
            node lastnode = node;
            while (lastnode.nextnode !=null){
                lastnode = lastnode.nextnode;
            }
            while (lastnode !=null ){
                if(lastnode.value!=null)
                    System.out.println(lastnode.value);
                lastnode = lastnode.previousnode;
            }
        }
    }

}


public class DoubleLinkListReverse{

    public static void main(String[] args) {
        //LinkedList-> print it decending value
        LinkedList linkedList= new LinkedList();
        linkedList.add("imran");
        linkedList.add("salman");
        linkedList.add("khan");
        linkedList.add("imran1");
        linkedList.add("salman1");
        linkedList.add("khan1");
        linkedList.printAll(false);
        System.out.println("--reverse--");
        linkedList.printAll(true);
        System.out.println("---remove elements----");
        linkedList.removefrom(0);
        linkedList.remove("salman1");
        linkedList.printAll(false);

/* single linked list reverse logic
//recursion
        Node firstNode = node;
        if (firstNode.next == null || firstNode == null) { // Base condition
            return firstNode;
        } else { // Recursive condition
            Node secondNode = firstNode.next;
            firstNode.next = null;
            Node reverseNode = reverse(secondNode);
            secondNode.next = firstNode;
            return reverseNode;
        }
//iterate
        public static Node reverseIterative(Node node) {
            Node prevNode = null;
            Node currNode = node;
            Node nextNode;
            while (currNode != null) {
                nextNode = currNode.next;
                currNode.next = prevNode;
                prevNode = currNode;
                currNode = nextNode;
            }
            return prevNode;
        }
    }*/

    }
}

