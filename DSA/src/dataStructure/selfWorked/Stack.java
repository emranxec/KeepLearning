package dataStructure.selfWorked;

public class Stack {
    private ArrayList myStack;
    int size;

    Stack(){
        myStack = new ArrayList();
        size=0;
    }
    public void push(Object o){
        myStack.add(o);
        size++;
    }
    public Object peek(){
        Object o=myStack.get(size-1);
        return o;
    }
    public Object pull(){
        Object o=myStack.get(size-1);
        myStack.remove(o);
        size--;
        return o;
    }

    public void printAll(){
        myStack.printAll();
    }

    public static void main(String[] args) {
        Stack stack=new Stack();
        System.out.println("---pushing------ :");
        stack.push(new Integer(1));
        stack.push(new Integer(2));
        stack.push(new Integer(3));
        stack.push(new Integer(5));
        stack.push(new Integer(10));
        stack.push(new Integer(11));
        stack.push(new Integer(12));
        stack.push(new Integer(13));
        stack.push(new Integer(15));
        stack.push(new Integer(110));


        stack.printAll();

        System.out.println("peeking ------" + stack.peek());
        stack.printAll();

        System.out.println("pulling----- " + stack.pull());
        stack.printAll();
        System.out.println("pulling----- " + stack.pull());
        stack.printAll();
        System.out.println("pulling----- " + stack.pull());
        stack.printAll();

    }

}
