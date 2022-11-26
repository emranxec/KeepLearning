package programs;

import programs.utilClasses.Lambda;
import programs.utilClasses.NumberWorker;

public class FunctionalInterfaceExample {

    public static void main(String[] args) {
        int x=10;
        Lambda lambda = ()-> "new lambda";
        System.out.println(lambda.demo());

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
