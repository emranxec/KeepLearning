package programs;

import programs.utilClasses.Lambda;

public class FunctionalInterfaceExample {

    public static void main(String[] args) {
        int x=10;
        Lambda lambda= ()-> System.out.println("new lambda");
        lambda.demo();
        new Thread(()-> System.out.println("The value of x is "+x)).start();

        NumberWorker<Integer> computerNumber= (n)-> {
            int result=1;
            for(int i=1;i<=n;i++){
                result=i*result;
            }
            return result;
        };

        System.out.println(computerNumber.compute(5));
    }


}
