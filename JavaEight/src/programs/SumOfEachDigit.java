package programs;

public class SumOfEachDigit {

    public static void main(String[] args) {
        String myNumber="123333333";
        int n=Integer.parseInt(myNumber);
        int sum=0;
        int reminder=0;
        while (n>0){
            System.out.println(n);
            reminder=n%10;
            n=n/10;
            sum+=reminder;
        }
        System.out.println("final :" +sum);
    }
}
