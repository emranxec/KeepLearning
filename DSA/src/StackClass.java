import java.util.Stack;

public class StackClass {

    public static void main(String[] args) {
        Stack<Integer> myStack= new Stack<>();
        myStack.push(0);
        myStack.push(1);
        myStack.push(1);
        myStack.push(3);
        myStack.push(2);
        myStack.push(2);
        myStack.pop();

        if(myStack.isEmpty()){
            System.out.println("stack is empty");
        }else {
            System.out.println("stack is not empty");
        }
        System.out.println(myStack.search(21)); //1 means exist
        System.out.println(myStack.peek());


    }



}
