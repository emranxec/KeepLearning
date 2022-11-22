package dataStructure.selfWorked;



class Node {
    Object value;
    Node nextNode;
    Node previousNode;
}

class LinkedList {
    Node node;
    int current=0;

    LinkedList() {
        node = new Node();
        node.nextNode = null;
        node.previousNode=null;
    }

    void add(Object value) {
        if (node.value == null) {
            node.value=value;
            Node newNode=new Node();
            newNode.previousNode=node;
            node.nextNode = newNode;
        } else {
            addChild(value, node.nextNode);
        }

    }

    private void addChild(Object value, Node childNode) {
        if (childNode.value == null) {
            childNode.value=value;
            Node newNode=new Node();
            newNode.previousNode=childNode;
            childNode.nextNode = newNode;
        } else {
            addChild(value, childNode.nextNode);
        }
    }

    void remove(Object value) {
        if(value!=null){
            if(node.value!=null && node.value==value){
                node=node.nextNode;
            }else{
                removeChild(value,node.nextNode);
            }
        }

    }
    void removefrom(int index) {
        if(index==0){
            node=node.nextNode;
        }else{
            current++;
            removeChildFrom(index,node.nextNode);
        }
        current=0;
    }

    private void removeChildFrom(int value, Node childNode) {
        if(current==value){
            childNode.previousNode.nextNode=childNode.nextNode;
        }else{
            if(childNode.nextNode==null) return;
            current++;
            removeChild(value,childNode.nextNode);
        }
    }

    private void removeChild(Object value, Node childNode) {
        if(childNode.value!=null && childNode.value==value){
            childNode.previousNode.nextNode=childNode.nextNode;
        }else{
            if(childNode.nextNode==null) return;
            removeChild(value,childNode.nextNode);
        }
    }

    void printAll(boolean printReverse) {
        Node printNode = node;
        if(!printReverse) {
            while (printNode.value != null) {
                System.out.println(printNode.value);
                if (printNode.nextNode != null) {
                    printNode = printNode.nextNode;
                } else {
                    break;
                }
            }
        }else{
            Node lastNode = node;
            while (lastNode.nextNode!=null){
                lastNode= lastNode.nextNode;
            }
            while (lastNode!=null ){
                if(lastNode.value!=null)
                    System.out.println(lastNode.value);
                lastNode=lastNode.previousNode;
            }
        }
    }

}


public class SomeMainClass {

    public static void main(String[] args) {
        //linkedlist -> print it decending value
        LinkedList linkedList = new LinkedList();
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


    }
}

