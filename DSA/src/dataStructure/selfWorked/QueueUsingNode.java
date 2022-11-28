package dataStructure.selfWorked;

public class QueueUsingNode<T> {

    static class Node<T>{
        final T data;
        Node<T> next;
        Node(T data) {
            this.data = data;
        }
    }

    Node<T> first,last;

    void enqueue(T item){
        if(first==null){
            first= new Node<>(item);
            last=first;
        }else{
            last.next= new Node<>(item);
            last=last.next;
        }
        System.out.println(first.data + "-" + last.data);
    }

    T dequeue(){
        if(first!=null){
            T item= first.data;
            first=first.next;
            return item;
        }
        return null;
    }
    public static void main(String[] args) {
        QueueUsingNode<Integer> test = new QueueUsingNode<>();
        test.enqueue(100);
        test.enqueue(200);
        System.out.println("test = " + test.dequeue());
        test.enqueue(300);
        test.enqueue(301);
        test.enqueue(302);
        System.out.println("test = " + test.dequeue());
        System.out.println("test = " + test.dequeue());
        System.out.println("test = " + test.dequeue());
        System.out.println("test = " + test.dequeue());
    }
}
